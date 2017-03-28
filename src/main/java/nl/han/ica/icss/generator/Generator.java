package nl.han.ica.icss.generator;

import nl.han.ica.icss.ast.*;

import java.util.ArrayList;

public class Generator {

	public String generate(AST ast) {
        StringBuilder builder = printNodes(ast.root.body, new ArrayList<>());
		return builder.toString();
	}

	//Go through each node. Keeping track of the parent.
	private StringBuilder printNodes(ArrayList<ASTNode> nodes, ArrayList<ASTNode> parent) {
        StringBuilder builder = new StringBuilder();
		for(ASTNode node : nodes) {
            if( !(node instanceof Stylerule) ) {
                continue;
            }
            StringBuilder rule = buildStylerule((Stylerule)node, parent);
            builder.append(rule.toString());
		}
		return builder;
	}

	//Build a declaration.
    private StringBuilder buildDeclartion(Declaration declaration) {
        StringBuilder builder = new StringBuilder();
        builder.append("\t");
        builder.append(declaration.property);
        builder.append(": ");
        builder.append(declaration.value);
        builder.append(";\n");
        return builder;
    }

    //Build a stylerule
    private StringBuilder buildStylerule(Stylerule rule, ArrayList<ASTNode> parent) {
        StringBuilder builder = new StringBuilder();
        builder.append(buildStyleruleSelector(rule, parent));
        builder.append(" {\n");
        for(ASTNode node : rule.getChildren()) {
            if( !(node instanceof Declaration) ) {
                continue;
            }
            StringBuilder declartion = buildDeclartion((Declaration)node);
            builder.append(declartion.toString());
        }
        builder.append("}\n\n");
        builder.append(buildStyleruleChildren(rule, parent));
        return builder;
    }

    //Build the child style rules.
    private StringBuilder buildStyleruleChildren(Stylerule rule, ArrayList<ASTNode> parent) {
        StringBuilder builder = new StringBuilder();
        ArrayList<ASTNode> children = rule.getChildren();
        if(!children.isEmpty()) {
            parent.add(rule);
            builder.append(printNodes(children, parent));
        }
        parent.clear();
        return builder;
    }

    private StringBuilder buildStyleruleSelector(Stylerule rule, ArrayList<ASTNode> parent) {
	    //Build parents
        StringBuilder builder = new StringBuilder();
        for(ASTNode node : parent) {
            if(!(node instanceof Stylerule) ) {
                continue;
            }
            Stylerule parentRule = (Stylerule)node;
            builder.append(parentRule.selector);
            builder.append(" > ");
        }
        builder.append(rule.selector);
        return builder;
    }

}
