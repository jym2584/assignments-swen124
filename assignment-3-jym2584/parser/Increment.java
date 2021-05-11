package parser;

public class Increment implements Expression {
    private final Expression expression;

    public Increment (Expression expression) {
        this.expression = expression;
    }

    @Override
    public double evaluate() {
        return expression.evaluate() + 1;
    }

    public static void main(String[] args) {
        Constant con = new Constant(5.2);
        Increment inc = new Increment(con);
        System.out.println(inc.evaluate());
    }
}