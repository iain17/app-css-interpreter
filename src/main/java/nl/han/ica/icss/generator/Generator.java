package nl.han.ica.icss.generator;

import nl.han.ica.icss.ast.*;

import java.util.ArrayList;

public class Generator {

	public String generate(AST ast) {
        StringBuilder builder = printNodes(ast.root.body);
		return builder.toString();
	}

	private StringBuilder printNodes(ArrayList<ASTNode> nodes) {
        StringBuilder builder = new StringBuilder();
		for(ASTNode node : nodes) {
            //CSS doesn't contain vars. :P

            if(node instanceof Stylerule) {
                StringBuilder rule = buildStylerule((Stylerule)node);
                builder.append(rule.toString());
                rule.append("\n");
            }

            if(node instanceof Declaration) {
                StringBuilder rule = buildDeclartion((Declaration)node);
                builder.append(rule.toString());
                rule.append("\n");
            }
		}
		return builder;
	}

	private StringBuilder buildAssignment(Assignment assignment) {
        StringBuilder builder = new StringBuilder();
        builder.append("$");
        builder.append(assignment.name.name);
        builder.append(" = ");
        builder.append(assignment.value);
        builder.append(";\n");
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

    private StringBuilder buildStylerule(Stylerule rule) {
        StringBuilder builder = new StringBuilder();
        builder.append(rule.selector);
        builder.append(" {\n");
        ArrayList<ASTNode> children = rule.getChildren();
        if(!rule.getChildren().isEmpty()) {
            //TODO: Indendation?
            StringBuilder childBuilder = printNodes(children);
            builder.append(childBuilder.toString());
        }
        builder.append("}\n");
        return builder;
    }

}
