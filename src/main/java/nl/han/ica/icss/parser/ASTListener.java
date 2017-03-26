package nl.han.ica.icss.parser;

import java.util.Objects;
import java.util.Stack;

import nl.han.ica.icss.ast.*;
import org.antlr.v4.runtime.misc.NotNull;

/**
 * This class extracts the ICSS Abstract Syntax Tree from the Antlr Parse tree.
 */
public class ASTListener extends ICSSBaseListener {
	
	private AST ast;
	private Stack stack;

	public ASTListener() {
		ast = new AST();
	}

	public AST getAST() {
		return ast;
	}

	@Override public void enterStylesheet(@NotNull ICSSParser.StylesheetContext ctx) {
		ast.setRoot(new Stylesheet());
		stack = new Stack();
	}

    @Override public void enterConstant(@NotNull ICSSParser.ConstantContext ctx) {
        Assignment assignment = new Assignment();
        assignment.name = new ConstantReference(ctx.constantName().getText());
        stack.add(assignment);
    }

    @Override public void exitConstant(@NotNull ICSSParser.ConstantContext ctx) {
        if(stack.peek() instanceof Assignment) {
            Assignment assignment = (Assignment) stack.pop();
            if(assignment.value == null) {
                System.out.printf("%s has no value", assignment.name.name);
                return;
            }
            ast.root.addChild(assignment);
        }
    }

    @Override public void enterStyleRule(@NotNull ICSSParser.StyleRuleContext ctx) {
        Stylerule rule = new Stylerule();
        rule.selector = new Selector();
        stack.add(rule);
    }

    @Override public void enterSelectorId(@NotNull ICSSParser.SelectorIdContext ctx) {
        if(stack.peek() instanceof Stylerule) {
            Stylerule rule = (Stylerule) stack.peek();
            rule.selector.id = ctx.ID().getText();
        }
    }

    @Override public void enterSelectorTag(@NotNull ICSSParser.SelectorTagContext ctx) {
        if(stack.peek() instanceof Stylerule) {
            Stylerule rule = (Stylerule) stack.peek();
            rule.selector.tag = ctx.ID().getText();
        }
    }

    @Override public void enterSelectorClass(@NotNull ICSSParser.SelectorClassContext ctx) {
        if(stack.peek() instanceof Stylerule) {
            Stylerule rule = (Stylerule) stack.peek();
            rule.selector.cls = ctx.ID().getText();
        }
    }

    @Override public void enterDeclaration(@NotNull ICSSParser.DeclarationContext ctx) {
        Declaration declaration = new Declaration();
        declaration.property = ctx.ID().getText();
        stack.push(declaration);
    }

    @Override public void enterColorLiteral(@NotNull ICSSParser.ColorLiteralContext ctx) {
        ColorLiteral value = new ColorLiteral(ctx.getText());
        if(stack.peek() instanceof Declaration) {
            Declaration declaration = (Declaration) stack.peek();
            declaration.value = value;
        }

        if(stack.peek() instanceof Assignment) {
            Assignment assignment = (Assignment) stack.peek();
            assignment.value = value;
        }

        if (stack.peek() instanceof Operation) {
            Operation operation = (Operation) stack.peek();
            if(operation.lhs == null) {
                operation.lhs = value;
            }
            if(operation.rhs == null) {
                operation.rhs = value;
            }
        }
    }

    @Override public void enterValueLiteral(@NotNull ICSSParser.ValueLiteralContext ctx) {
	    String sValue = ctx.LiteralValue().getText();
	    Value value = null;
	    if(sValue.contains("%")) {
	        value = new PercentageLiteral(sValue);
        }
        if(sValue.contains("px")) {
            value = new PixelLiteral(sValue);
        }

        if(stack.peek() instanceof Declaration) {
            Declaration declaration = (Declaration) stack.peek();
            declaration.value = value;
        }

        if(stack.peek() instanceof Assignment) {
            Assignment assignment = (Assignment) stack.peek();
            assignment.value = value;
        }

        if (stack.peek() instanceof Operation) {
            Operation operation = (Operation) stack.peek();
            if(operation.lhs == null) {
                operation.lhs = value;
            }else if(operation.rhs == null) {
                operation.rhs = value;
            }
        }
    }

    @Override public void enterConstantName(@NotNull ICSSParser.ConstantNameContext ctx) {
        String name = ctx.ID().getText();
        Value value = new ConstantReference(name);
        if (stack.peek() instanceof Declaration) {
            Declaration declaration = (Declaration) stack.peek();
            declaration.value = value;
        }

        if (stack.peek() instanceof Operation) {
            Operation operation = (Operation) stack.peek();
            if(operation.lhs == null) {
                operation.lhs = value;
            }else if(operation.rhs == null) {
                operation.rhs = value;
            }
        }
    }

    @Override public void exitOperation(@NotNull ICSSParser.OperationContext ctx) {
        if(stack.peek() instanceof Operation) {
            Operation operation = (Operation) stack.pop();
            if(operation.lhs == null || operation.rhs == null) {
                System.out.printf("operation has no lhs(%s) or rhs(%s)", operation.lhs, operation.rhs);
                return;
            }
            ASTNode parent = (ASTNode)stack.peek();
            if(parent instanceof Declaration) {
                ((Declaration) parent).value = operation;
            } else {
                parent.addChild(operation);
            }
        }
    }

    @Override public void enterOperation(@NotNull ICSSParser.OperationContext ctx) {
	    Operation operation = new Operation();
	    //If its an operation with an operator it is worth to put on the stack. Otherwise its just part of the value of another operator.
	    if(ctx.Operator() != null) {
            switch (ctx.Operator().getText()) {
                case "+":
                    operation.operator = Operation.Operator.PLUS;
                    break;
                case "-":
                    operation.operator = Operation.Operator.MIN;
                    break;
                default:
                    System.out.printf("Missing operator mapping of %s", ctx.Operator().getText());
            }
            stack.push(operation);
	    }
    }

    @Override public void exitDeclaration(@NotNull ICSSParser.DeclarationContext ctx) {
        if(stack.peek() instanceof Declaration) {
            Declaration declaration = (Declaration) stack.pop();
            if(declaration.value == null) {
                System.out.printf("%s has no value", declaration.property);
                return;
            }
            if(stack.peek() instanceof Stylerule) {
                Stylerule rule = (Stylerule) stack.peek();
                rule.addChild(declaration);
            }
        }
    }

	@Override public void exitStyleRule(@NotNull ICSSParser.StyleRuleContext ctx) {
	    if(stack.peek() instanceof Stylerule) {
            Stylerule rule = (Stylerule) stack.pop();

            ASTNode parent = null;
            if(!stack.empty()) {
                parent = (ASTNode) stack.peek();
            } else {
                parent = ast.root;
            }
            parent.addChild(rule);
        }
	}
}