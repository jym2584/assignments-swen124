package products;
import toys.*;


public abstract class Product {
    protected final String name;
    protected final int productCode;
    protected final double msrp;
    /**
     * Product
     * @param name a name for the product
     * @param productCode product number, 7 digits would be nice
     * @param msrp price for the product
     */
    protected Product(String name, int productCode, double msrp) {
        this.name = name;
        this.productCode = productCode;
        this.msrp = msrp;
    }

    public String getName() { return name; }
    public int getProductCode() { return productCode; }
    public double getMsrp() { return msrp; }
    
}