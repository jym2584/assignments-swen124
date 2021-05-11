package parser;

public class Constant implements Expression {
    private final double constantt;
    
    public Constant(double constantt) {
        this.constantt = constantt;
    }

    @Override
    public double evaluate() {
        return constantt;
    }

    public static void main(String[] args) {
        Constant pi = new Constant(3.1415);
        System.out.println(pi.evaluate());
    }
}