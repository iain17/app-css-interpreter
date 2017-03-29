package nl.han.ica.icss.checker;

import java.util.*;
import nl.han.ica.icss.ast.*;

public class Checker {

    public enum ValueType {
        PIXELVALUE,
        PERCENTAGE,
        COLORVALUE,
        UNDEFINED
    }

    //Rules for CH03 and CH04. Only added the ones referenced in the levels.
    private static final Map<String, ArrayList<ValueType>> semantics = Collections.unmodifiableMap(
        new HashMap<String, ArrayList<ValueType>>() {{
            put("width", new ArrayList<>(Arrays.asList(ValueType.PIXELVALUE, ValueType.PERCENTAGE)));
            put("height", new ArrayList<>(Arrays.asList(ValueType.PIXELVALUE, ValueType.PERCENTAGE)));
            put("color", new ArrayList<>(Arrays.asList(ValueType.COLORVALUE)));
            put("background-color", new ArrayList<>(Arrays.asList(ValueType.COLORVALUE)));
        }}
    );

    //Used to keep track of variables.
    private HashMap<String,Value> symboltable;

	public void check(AST ast) {
	    //Clear
        symboltable = new HashMap<>();

        if(ast.root.getChildren().isEmpty()) {
            ast.root.setError("No input given.");
        }

        //DO THE CHECKING HERE...
        checkNodes(ast.root.body);

		//Save the symboltable.
        ast.symboltable = symboltable;
        //Save the verdict
		if(ast.getErrors().isEmpty()) {
            ast.checked = true;
        }
	}

    //Check style rules.
    private void checkNodes(ArrayList<ASTNode> nodes) {
        for(ASTNode node : nodes) {
            if(!node.getChildren().isEmpty()) {
                checkNodes(node.getChildren());
            }

            if(node instanceof Assignment) {
                addVar((Assignment)node);
            }

            if(node instanceof Declaration) {
                checkDeclaration((Declaration)node);
                continue;
            }
        }
    }

    //CH02: Controleer of er geen constantes worden gedefinieerd die al bestaan.
    private void addVar(Assignment assignment) {
        //Does this constant already exist?
        if(symboltable.containsKey(assignment.name.name)) {
            assignment.setError(String.format("CH02: constant '%s' already defined.", assignment.name.name));
            return;
        }
        if(assignment.value instanceof ConstantReference) {
            checkConstantReference((ConstantReference)assignment.value, assignment);
        }
        if(assignment.value instanceof Operation) {
            checkOperation((Operation)assignment.value, assignment);
        }
        symboltable.put(assignment.name.name, assignment.value);
    }

    //Check a declaration.
    private void checkDeclaration(Declaration declaration) {
        //CH01: Controleer of er geen constantes in declaraties worden gebruikt die nog niet gedefinieerd zijn.
        if(declaration.value instanceof ConstantReference) {
            checkConstantReference((ConstantReference)declaration.value, declaration);
        }

        if(declaration.value instanceof Operation) {
            checkOperation((Operation) declaration.value, declaration);
        }

        if (semantics.containsKey(declaration.property)) {
            checkValue("property " + declaration.property, declaration.value, semantics.get(declaration.property));
        }
    }

    //Check value with a list of what is acceptable.
    private void checkValue(String name, Value value, ArrayList<ValueType> accepts) {
        ValueType type = getValueType(value);
        if(!accepts.contains(type)) {
            switch(type) {
                case PIXELVALUE:
                    value.setError(String.format("CH04: Unexpected pixel value for %s", name));
                    break;
                case PERCENTAGE:
                    value.setError(String.format("CH04: Unexpected percentage value for %s", name));
                    break;
                case COLORVALUE:
                    value.setError(String.format("CH04: Unexpected color value for %s", name));
                    break;
                case UNDEFINED:
                    value.setError(String.format("CH04: Unexpected undefined value for %s", name));
                    break;
            }
        }
    }

    //Map value to a ValueType
    private ValueType getValueType(Value value) {
	    if(value instanceof PixelLiteral) {
	        return ValueType.PIXELVALUE;
        }

        if(value instanceof PercentageLiteral) {
            return ValueType.PERCENTAGE;
        }

        if(value instanceof ColorLiteral) {
	        return ValueType.COLORVALUE;
        }

        if(value instanceof Operation) {
	        return getValueType(((Operation)value).lhs);
        }

        if(value instanceof ConstantReference) {
	        ConstantReference reference = (ConstantReference)value;
            if(symboltable.containsKey(reference.name)) {
                Value refValue = symboltable.get(reference.name);
                return getValueType(refValue);
            }
        }
        return ValueType.UNDEFINED;
    }

    //Check operations.
    private void checkOperation(Operation operation, ASTNode parent) {
	    //lhs
	    if(operation.lhs instanceof ConstantReference) {
	        checkConstantReference((ConstantReference)operation.lhs, parent);
        }
        if(operation.lhs instanceof Operation) {
            checkOperation((Operation) operation.lhs, parent);
        }
        //rhs
        if(operation.rhs instanceof ConstantReference) {
            checkConstantReference((ConstantReference)operation.rhs, parent);
        }
        if(operation.rhs instanceof Operation) {
            checkOperation((Operation) operation.rhs, parent);
        }
        //Check operation types. take left as leading.
        ValueType lhsType = getValueType(operation.lhs);
        ValueType rhsType = getValueType(operation.rhs);
        if(rhsType != lhsType) {
            operation.setError(String.format("CH03: operation type mismatch. Right type (%s) is not of the same type as left (%s).", rhsType, lhsType));
        }
    }

    //Check if constant exists in a constant reference.
    private void checkConstantReference(ConstantReference reference, ASTNode parent) {
        //CH01: Controleer of er geen constantes in declaraties worden gebruikt die nog niet gedefinieerd zijn.
        if(!symboltable.containsKey(reference.name)) {
            parent.setError(String.format("CH01: Undefined reference to constant '%s'", reference.name));
        }
    }

}
