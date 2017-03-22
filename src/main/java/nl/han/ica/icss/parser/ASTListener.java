package nl.han.ica.icss.parser;

import java.util.List;
import java.util.Stack;
import nl.han.ica.icss.ast.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

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

	}



}