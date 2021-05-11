package parser;

public class Addition implements Expression {
    private final Expression left;
    private final Expression right;

    public Addition (Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double evaluate() {
        return left.evaluate() + right.evaluate();
    }

    public static void main(String[] args) {
        Constant con = new Constant(5.2);
        Increment inc = new Increment(con);
        Addition add = new Addition(con, inc);
        System.out.println(add.evaluate());
    }
}
