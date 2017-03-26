package nl.han.ica.icss.generator;

import nl.han.ica.icss.ast.*;

import java.util.ArrayList;

public class Generator {

	public String generate(AST ast) {
        StringBuilder builder = printNodes(ast.root.body, new ArrayList<ASTNode>());
		return builder.toString();
	}

	private StringBuilder printNodes(ArrayList<ASTNode> nodes, ArrayList<ASTNode> parent) {
        StringBuilder builder = new StringBuilder();
		for(ASTNode node : nodes) {
            if(node instanceof Stylerule) {
                StringBuilder rule = buildStylerule((Stylerule)node, parent);
                builder.append(rule.toString());
            }
		}
		return builder;
	}

    private StringBuilder buildDeclartion(Declaration declaration) {
        StringBuilder builder = new StringBuilder();
        builder.append(declaration.property);
        builder.append(": ");
        builder.append(declaration.value);
        builder.append(";\n");
        return builder;
    }

    private StringBuilder buildStylerule(Stylerule rule, ArrayList<ASTNode> parent) {
        StringBuilder builder = new StringBuilder();
        if(!parent.isEmpty()) {
            for(ASTNode node : parent) {
                if(node instanceof Stylerule) {
                    Stylerule parentRule = (Stylerule)node;
                    builder.append(parentRule.selector + " > ");
                }
            }
        }
        builder.append(rule.selector);
        builder.append(" {\n");
        for(ASTNode node : rule.getChildren()) {
            if(node instanceof Declaration) {
                StringBuilder declartion = buildDeclartion((Declaration)node);
                builder.append(declartion.toString());
            }
        }
        builder.append("}\n\n");

        //Children
        ArrayList<ASTNode> children = rule.getChildren();
        if(!children.isEmpty()) {
            parent.add(rule);
            StringBuilder childBuilder = printNodes(children, parent);
            builder.append(childBuilder.toString());
        }
        parent.clear();

        return builder;
    }

}
