package nl.han.ica.icss.transforms;

import nl.han.ica.icss.ast.*;

import java.awt.*;
import java.util.ArrayList;

public class EvalOperations implements Transform {

    @Override
    public void apply(AST ast) {
        evalOperations(ast.root.body);
    }

    public void evalOperations(ArrayList<ASTNode> nodes) {
        for(ASTNode node : nodes) {
            evalOperation(node);
        }
    }

    public void evalOperation(ASTNode node) {
        ArrayList<ASTNode> children = node.getChildren();
        if(!children.isEmpty()) {
            evalOperations(children);
        }

        if(node instanceof Assignment) {
            updateAssignment((Assignment)node);
        }

        if(node instanceof Declaration) {
            updateDeclaration((Declaration)node);
        }

    }

    public void updateDeclaration(Declaration declaration) {
        if(declaration.value instanceof Operation) {
            declaration.value = getValueFromOperation((Operation)declaration.value);
        }
    }

    public void updateAssignment(Assignment assignment) {
        if(assignment.value instanceof Operation) {
            assignment.value = getValueFromOperation((Operation)assignment.value);
        }
    }

    private Value getValueFromOperation(Operation operation) {
        int total = getValues(operation);
        if(operation.lhs instanceof PixelLiteral) {
            return new PixelLiteral(total);
        }
        if(operation.lhs instanceof PercentageLiteral) {
            return new PercentageLiteral(total);
        }
        if(operation.lhs instanceof ColorLiteral) {
            return new ColorLiteral("#"+Integer.toHexString(total).toUpperCase());
        }
        return null;
    }

    private int getValues(Operation operation) {
        int lhs = getValue(operation.lhs);
        int rhs = getValue(operation.rhs);
        return lhs + rhs;
    }

    //Returns a value in a int representation.
    private int getValue(Value value) {
        if(value instanceof PixelLiteral) {
            return ((PixelLiteral)value).value;
        }
        if(value instanceof PercentageLiteral) {
            return ((PercentageLiteral)value).value;
        }
        if(value instanceof ColorLiteral) {
            String sValue = ((ColorLiteral)value).value;
            return Integer.parseInt(sValue.replace("#", ""), 16);
        }
        if(value instanceof Operation) {
            return getValues((Operation)value);
        }

        return 0;
    }
}
