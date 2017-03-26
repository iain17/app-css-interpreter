package nl.han.ica.icss.ast;

public class ColorLiteral extends Literal {
    public String value;

    public ColorLiteral(String value) {
        this.value = value;
    }
    @Override
    public String getNodeLabel() {
        return "Color literal (" + value + ")";
    }

    //Added this to simplify the css generation.
    public String toString() {
        return value;
    }
}
