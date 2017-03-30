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
        buildSymbolsTable(ast.root.body);
        checkNodes(ast.root.body);

		//Save the symboltable.
        ast.symboltable = symboltable;
        //Save the verdict
		if(ast.getErrors().isEmpty()) {
            ast.checked = true;
        }
	}

	//Another weird rule: You may use constants that are defined later.
    //So we'll build the symbols tree prior to the further checks.
    //aka: 'Je mag constantes gebruiken die pas verderop in het document gedefinieerd worden.'
    private void buildSymbolsTable(ArrayList<ASTNode> nodes) {
        for(ASTNode node : nodes) {
            if(!node.getChildren().isEmpty()) {
                buildSymbolsTable(node.getChildren());
            }

            if(node instanceof Assignment) {
                addVar((Assignment)node);
            }
        }
    }

    //Check style rules.
    private void checkNodes(ArrayList<ASTNode> nodes) {
        for(ASTNode node : nodes) {
            if(!node.getChildren().isEmpty()) {
                checkNodes(node.getChildren());
            }

            if(node instanceof Assignment) {
                checkAssignment((Assignment)node);
            }

            if(node instanceof Declaration) {
                checkDeclaration((Declaration)node);
                continue;
            }
        }
    }

    private void addVar(Assignment assignment) {
        //Does this constant already exist?
        if(symboltable.containsKey(assignment.name.name)) {
            assignment.setError(String.format("CH02: constant '%s' already defined.", assignment.name.name));
            return;
        }
        symboltable.put(assignment.name.name, assignment.value);
    }

    //This check, checks if we don't do operation like:
    //$a = $a;//Which would cause an infinite loop when transforming.
    private boolean isDoubleReferenced(ASTNode node, String find) {
        if(node instanceof Operation) {
            Operation operation = (Operation)node;
            if(isDoubleReferenced(operation.lhs, find)) {
                return true;
            }
            if(isDoubleReferenced(operation.rhs, find)) {
                return true;
            }
        }
	    if(node instanceof ConstantReference) {
            ConstantReference reference = (ConstantReference)node;
            if(Objects.equals(reference.name, find)) {
                return true;
            } else {
                if(symboltable.containsKey(reference.name)) {
                    isDoubleReferenced(symboltable.get(reference.name), find);
                }
            }
        }
        return false;
    }

    //Check a declaration.
    private void checkDeclaration(Declaration declaration) {
        checkValue(declaration.value, declaration);
        //CH01: Controleer of er geen constantes in declaraties worden gebruikt die nog niet gedefinieerd zijn.
        if (semantics.containsKey(declaration.property)) {
            checkValueSemantically(String.format("property %s", declaration.property), declaration.value, semantics.get(declaration.property), declaration);
        } else {
            declaration.setError("Only the properties: color, background-color, width and height are allowed.");
        }
    }

    //Check value with a list of what is acceptable.
    private void checkValueSemantically(String name, Value value, ArrayList<ValueType> accepts, ASTNode parent) {
        ValueType type = getValueType(value);
        if(!accepts.contains(type)) {
            switch(type) {
                case PIXELVALUE:
                    parent.setError(String.format("CH04: Unexpected pixel value for %s", name));
                    break;
                case PERCENTAGE:
                    parent.setError(String.format("CH04: Unexpected percentage value for %s", name));
                    break;
                case COLORVALUE:
                    parent.setError(String.format("CH04: Unexpected color value for %s", name));
                    break;
                default:
                case UNDEFINED:
                    parent.setError(String.format("CH04: Unexpected undefined value for %s", name));
                    break;
            }
        }
    }

    //CH02: Controleer of er geen constantes worden gedefinieerd die al bestaan.
    //Controlleer ook gelijk de value van de assignment.
    private void checkAssignment(Assignment assignment) {
        checkValue(assignment.value, assignment);
        //Detect inception limbo. $a = $a;
        if(isDoubleReferenced(assignment.value, assignment.name.name)) {
            assignment.setError(String.format("You cannot use constant %s as a value of that constant.", assignment.name.name));
        }
    }

    private void checkValue(Value value, ASTNode parent) {
        if(value instanceof ConstantReference) {
            checkConstantReference((ConstantReference)value, parent);
        }
        if(value instanceof Operation) {
            checkOperation((Operation)value, parent);
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
                if(refValue == value) {
                    return ValueType.UNDEFINED;
                }
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
        checkValue(operation.lhs, operation);
        checkValue(operation.rhs, operation);
        //Check operation types. take left as leading.
        ValueType lhsType = getValueType(operation.lhs);
        ValueType rhsType = getValueType(operation.rhs);
        if(rhsType != lhsType) {
            parent.setError(String.format("CH03: operation type mismatch. Right type (%s) is not of the same type as left (%s).", rhsType, lhsType));
        }

        checkStupidOperationRule(lhsType, parent);
        checkStupidOperationRule(rhsType, parent);
    }

    //For some stupid reason only pixels and percentages may be used in calculations.
    //So goodbye color operations ;-(. Don't blame me, I'm just a messenger. The rules were not made by me.
    private void checkStupidOperationRule(ValueType valueType, ASTNode parent) {
	    if(valueType != ValueType.PIXELVALUE && valueType != ValueType.PERCENTAGE) {
	        parent.setError("A operation may only contain pixel or percentage values!");
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
