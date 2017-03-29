package nl.han.ica.icss.transforms;

import nl.han.ica.icss.ast.*;

import java.util.ArrayList;
import java.util.HashMap;

public class InlineConstants implements Transform {
    private HashMap<String,Value> symboltable;

    @Override
    public void apply(AST ast) {
        symboltable = new HashMap<>();
        buildSymbolsTable(ast.root.body);
        replaceReferences(ast.root.body);
    }

    private void buildSymbolsTable(ArrayList<ASTNode> nodes) {
        for(ASTNode node : nodes) {
            if(node == null) {
                continue;
            }
            ArrayList<ASTNode> childrenNodes = node.getChildren();

            if(childrenNodes != null && !childrenNodes.isEmpty()) {
                buildSymbolsTable(node.getChildren());
            }

            if(node instanceof Assignment) {
                Assignment assignment = (Assignment)node;
                symboltable.put(assignment.name.name, assignment.value);
            }
        }
    }

    private void replaceReferences(ArrayList<ASTNode> nodes) {
        for(ASTNode node : nodes) {
            replaceReference(node);
        }
    }

    private void replaceReference(ASTNode node) {
        ArrayList<ASTNode> children = node.getChildren();
        if(!children.isEmpty()) {
            replaceReferences(children);
        }

        if(node instanceof Declaration) {
            Declaration declaration = (Declaration)node;
            declaration.value = resolveValue(declaration.value);
        }

        if(node instanceof Assignment) {
            Assignment assignment = (Assignment)node;
            assignment.value = resolveValue(assignment.value);
        }

        if(node instanceof Operation) {
            Operation operation = (Operation)node;
            operation.lhs = resolveValue(operation.lhs);
            operation.rhs = resolveValue(operation.rhs);
        }
    }

    private Value resolveValue(Value value) {
        while(value instanceof ConstantReference) {
            ConstantReference reference = (ConstantReference)value;
            value = symboltable.get(reference.name);
        }
        if(value instanceof Operation) {
            Operation operation = (Operation)value;
            operation.lhs = resolveValue(operation.lhs);
            operation.rhs = resolveValue(operation.rhs);
            value = operation;
        }
        return value;
    }

}
