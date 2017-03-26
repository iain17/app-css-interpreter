package nl.han.ica.icss.ast;

public class PixelLiteral extends Literal {
    public int value;

    public PixelLiteral(int value) {
        this.value = value;
    }
    public PixelLiteral(String text) {
        this.value = Integer.parseInt(text.substring(0, text.length() - 2));
    }
    @Override
    public String getNodeLabel() {
        return "Pixel literal (" + value + ")";
    }

    //Added this to simplify the css generation.
    public String toString() {
        return String.valueOf(value)+"px";
    }
}
