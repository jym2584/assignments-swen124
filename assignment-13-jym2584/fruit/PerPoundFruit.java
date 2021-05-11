package fruit;

public class PerPoundFruit extends Fruit {
    private final double weight;

    protected PerPoundFruit(String name, double price, double weight) {
        super(name, price);
        this.weight = weight;
    }

    @Override
    public double price() {
        return super.price() * weight;
    }

    @Override
    public String toString() {
        return String.format("%s: $%s x %s lbs              = $%.2f", name, price, weight, this.price());
    }
    
}
