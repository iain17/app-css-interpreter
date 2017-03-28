package nl.han.ica.icss.transforms;

import nl.han.ica.icss.ast.*;

import java.util.ArrayList;
import java.util.HashMap;

public class InlineConstants implements Transform {
    private HashMap<String,Value> symboltable;

    @Override
    public void apply(AST ast) {
        symboltable = new HashMap<>();
        replaceReferences(ast.root.body);
    }

    private void replaceReferences(ArrayList<ASTNode> nodes) {
        for(ASTNode node : nodes) {
            replaceReference(node);
        }
    }

    private void replaceReference(ASTNode node) {
        if(node instanceof Assignment) {
            Assignment assignment = (Assignment)node;
            symboltable.put(assignment.name.name, assignment.value);
            return;
        }
        ArrayList<ASTNode> children = node.getChildren();
        if(!children.isEmpty()) {
            replaceReferences(children);
        }

        if(node instanceof Declaration) {
            updateDeclaration((Declaration)node);
        }

        if(node instanceof Operation) {
            updateOperation((Operation)node);
        }
    }

    private void updateDeclaration(Declaration declaration) {
        if(declaration.value instanceof ConstantReference) {
            ConstantReference reference = (ConstantReference)declaration.value;
            Value refValue = symboltable.get(reference.name);
            declaration.value = refValue;
        }
    }

    private void updateOperation(Operation declaration) {
        if(declaration.lhs instanceof ConstantReference) {
            ConstantReference reference = (ConstantReference)declaration.lhs;
            Value refValue = symboltable.get(reference.name);
            declaration.lhs = refValue;
        }

        if(declaration.rhs instanceof ConstantReference) {
            ConstantReference reference = (ConstantReference)declaration.rhs;
            Value refValue = symboltable.get(reference.name);
            declaration.rhs = refValue;
        }

        if(declaration.lhs instanceof Operation) {
            updateOperation((Operation)declaration.lhs);
        }

        if(declaration.rhs instanceof Operation) {
            updateOperation((Operation)declaration.rhs);
        }
    }

}
