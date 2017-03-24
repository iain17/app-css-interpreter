package nl.han.ica.icss.parser;

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
    }

    @Override public void enterConstantName(@NotNull ICSSParser.ConstantNameContext ctx) {
	    String name = ctx.ID().getText();
        if(stack.peek() instanceof Declaration) {
            Declaration declaration = (Declaration) stack.peek();
            declaration.value = new ConstantReference(name);
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
            ast.root.addChild(rule);
        }
	}
}