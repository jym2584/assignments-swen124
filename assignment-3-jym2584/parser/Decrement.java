package parser;

public class Decrement implements Expression {
    private final Expression expression;

    public Decrement (Expression expression) {
        this.expression = expression;
    }

    @Override
    public double evaluate() {
        return expression.evaluate() - 1;
    }

    public static void main(String[] args) {
        Constant con = new Constant(5.2);
        Increment inc = new Increment(con);
        Decrement dec = new Decrement(inc);
        System.out.println(dec.evaluate());
    }
}