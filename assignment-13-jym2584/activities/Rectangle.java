package activities;

public class Rectangle implements Shape {
    private String name;
    private double length;
    private double width;

    public Rectangle(String name, double length, double width) {
        this.name = name;
        this.length = length;
        this.width = width;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public double perimeter() {
        return 2* length + 2 * width;
    }
    
}
