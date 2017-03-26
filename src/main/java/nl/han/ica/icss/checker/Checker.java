package nl.han.ica.icss.checker;

import java.awt.*;
import java.util.*;

import com.sun.tools.internal.jxc.ap.Const;
import nl.han.ica.icss.ast.*;

public class Checker {

    public enum ValueType {
        PIXELVALUE,
        PERCENTAGE,
        COLORVALUE,
        UNDEFINED
    }

    //http://stackoverflow.com/questions/13445701/how-to-create-a-static-map-of-string-array
    private static final Map<String, ArrayList<ValueType>> semantics = Collections.unmodifiableMap(
        new HashMap<String, ArrayList<ValueType>>() {{
            put("width", new ArrayList<>(Arrays.asList(ValueType.PIXELVALUE)));
        }}
    );

    private HashMap<String,Value> symboltable;

	public void check(AST ast) {
	    //Clear
        symboltable = new HashMap<>();

        //DO THE CHECKING HERE...
        addVars(ast);
        checkStylerules(ast);

		//Save the symboltable.
        ast.symboltable = symboltable;
        //Save the verdict
		if(ast.getErrors().isEmpty()) {
            ast.checked = true;
        }
	}

    //CH02: Controleer of er geen constantes worden gedefinieerd die al bestaan.
	public void addVars(AST ast) {
	    for(ASTNode node : ast.root.body) {
	        if(!(node instanceof Assignment)) {
	            continue;
            }
            Assignment assignment = (Assignment)node;
	        //Does this constant already exist?
	        if(symboltable.containsKey(assignment.name.name)) {
	            node.setError(String.format("CH02: constant '%s' already defined.", assignment.name.name));
	            continue;
            }
	        symboltable.put(assignment.name.name, assignment.value);
        }
    }

    public void checkStylerules(AST ast) {
        for(ASTNode node : ast.root.body) {
            if(node instanceof Stylerule) {
                checkStyleRule((Stylerule)node);
            }
        }
    }

    public void checkStyleRule(Stylerule rule) {
        for(ASTNode node : rule.getChildren()) {
            if(node instanceof Declaration) {
                checkDeclaration((Declaration)node);
                continue;
            }
            if(rule instanceof Stylerule) {
                checkStyleRule((Stylerule)node);
                continue;
            }
        }
    }

    public void checkDeclaration(Declaration declaration) {
        //CH01: Controleer of er geen constantes in declaraties worden gebruikt die nog niet gedefinieerd zijn.
        if(declaration.value instanceof ConstantReference) {
            checkConstantReference((ConstantReference)declaration.value);
        }

        if(declaration.value instanceof Operation) {
            checkOperation((Operation) declaration.value);
        }

        if (semantics.containsKey(declaration.property)) {
            checkValue("property " + declaration.property, declaration.value, semantics.get(declaration.property));
        }
    }

    public void checkValue(String name, Value value, ArrayList<ValueType> accepts) {
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

    public ValueType getValueType(Value value) {
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

    public void checkOperation(Operation operation) {
	    //lhs
	    if(operation.lhs instanceof ConstantReference) {
	        checkConstantReference((ConstantReference)operation.lhs);
        }
        if(operation.lhs instanceof Operation) {
            checkOperation((Operation) operation.lhs);
        }
        //rhs
        if(operation.rhs instanceof ConstantReference) {
            checkConstantReference((ConstantReference)operation.rhs);
        }
        if(operation.rhs instanceof Operation) {
            checkOperation((Operation) operation.rhs);
        }
        ValueType lhsType = getValueType(operation.lhs);
        ValueType rhsType = getValueType(operation.rhs);
        if(rhsType != lhsType) {
            operation.setError(String.format("CH03: operation type mismatch. Right type (%s) is not of the same type as left (%s).", rhsType, lhsType));
        }
    }

    public void checkConstantReference(ConstantReference reference) {
        //CH01: Controleer of er geen constantes in declaraties worden gebruikt die nog niet gedefinieerd zijn.
        if(!symboltable.containsKey(reference.name)) {
            reference.setError(String.format("CH01: Undefined reference to constant '%s'", reference.name));
        }
    }

}
