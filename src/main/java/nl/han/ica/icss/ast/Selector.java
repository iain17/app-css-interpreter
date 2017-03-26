package nl.han.ica.icss.ast;

public class Selector extends ASTNode {
	public String tag;
	public String cls;
	public String id;

    @Override
    public String getNodeLabel() {
        return "Selector";
    }

    //Changed it so that it returns # or . if it is a class or id. To simplify the css generation.
    @Override
    public String toString() {
        if(tag != null)
            return tag;
		else if(cls != null)
		    return "."+cls;
		else
            return "#"+id;
    }
}
