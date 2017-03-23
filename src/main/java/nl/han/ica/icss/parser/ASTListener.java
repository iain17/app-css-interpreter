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

	@Override public void exitStylesheet(@NotNull ICSSParser.StylesheetContext ctx) {
        System.out.println();
	}

    @Override public void enterStyleRule(@NotNull ICSSParser.StyleRuleContext ctx) {
        Stylerule rule = new Stylerule();
        rule.selector = new Selector();
        rule.selector.tag = ctx.selector().ID().getText();

        stack.add(rule);
    }

    @Override public void enterDeclarationValue(@NotNull ICSSParser.DeclarationValueContext ctx) {
	    Declaration declaration = new Declaration();
//	    declaration.property = ctx.
    }

    @Override public void exitDeclarationValue(@NotNull ICSSParser.DeclarationValueContext ctx) {

    }

	@Override public void exitStyleRule(@NotNull ICSSParser.StyleRuleContext ctx) {
	    if(stack.peek() instanceof Stylerule) {
            Stylerule rule = (Stylerule) stack.pop();
            System.out.println(rule);
        }
	}

}