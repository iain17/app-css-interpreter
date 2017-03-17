package nl.han.ica.icss.parser;

import java.util.Stack;
import nl.han.ica.icss.ast.*;

/**
 * This class extracts the ICSS Abstract Syntax Tree from the Antlr Parse tree.
 */
public class ASTListener extends ICSSBaseListener {
	
	private AST ast;

	public ASTListener() {
		ast = new AST();
	}
	public AST getAST() {
		return ast;
	}
}