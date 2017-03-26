package nl.han.ica.icss.checker;

import java.util.HashMap;

import nl.han.ica.icss.ast.*;

public class Checker {

    public enum ValueType {
        PIXELVALUE,
        PERCENTAGE,
        COLORVALUE,
        UNDEFINED
    }

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
//        for(ASTNode node : declaration.getChildren()) {
//            System.out.println("a");
//        }
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
    }

    public void checkConstantReference(ConstantReference reference) {
        //CH01: Controleer of er geen constantes in declaraties worden gebruikt die nog niet gedefinieerd zijn.
        if(!symboltable.containsKey(reference.name)) {
            reference.setError(String.format("CH01: Undefined reference to constant '%s'", reference.name));
        }
    }

}
