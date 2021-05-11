package fruit;

public abstract class Fruit implements Cost {
    protected final String name;
    protected final double price;

    protected Fruit(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public double price() {
        return price;
    }

}
