package nl.han.ica.icss.ast;

public class PercentageLiteral extends Literal {
    public int value;

    public PercentageLiteral(int value) {
        this.value = value;
    }
    public PercentageLiteral(String text) {
        this.value = Integer.parseInt(text.substring(0, text.length() - 1));
    }
    @Override
    public String getNodeLabel() {
        return "Percentage literal (" + value + ")";
    }

    //Added this to simplify the css generation.
    public String toString() {
        return String.valueOf(value)+"%";
    }
}
