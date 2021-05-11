package fruit;

public class PerUnitFruit extends Fruit {
    private final int count;

    protected PerUnitFruit(String name, double price, int count) {
        super(name, price);
        this.count = count;
    }

    @Override
    public double price() {
        return super.price() * count;
    }

    @Override
    public String toString() {
        return String.format("%s: $%s x %s            = $%s", name, price, count, this.price());
    }
    
}
