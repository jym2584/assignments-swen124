package activities;

public class Car {
    private String vin;
    private double fuel;
    private int miles;

    public Car(String vin, double fuel, int miles) {
        this.vin = vin;
        this.fuel = fuel;
        this.miles = miles;
    }

    public double getFuel() {
        return fuel;
    }
    public int getMiles() {
        return miles;
    }
    public String getVin() {
        return vin;
    }

    @Override
    public String toString() {
        String str = "Car{vin: " + vin + " | gas: " + fuel + " | miles: " + miles + "}";
        return str;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Car) {
            Car o = (Car)obj;
            return this.vin == o.vin;
        }
        return false;
    }
    @Override
    public int hashCode() {
        return vin.hashCode() + miles;
    }
}
