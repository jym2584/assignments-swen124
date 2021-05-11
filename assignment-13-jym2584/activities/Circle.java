package activities;

public class Circle extends AbstractShape {
    private double radius;
    private double pi;

    public Circle(double radius) {
        super("Circle");
        this.radius = radius;
        this.pi = Math.PI;
    }

    public double area() {
        return (pi * Math.pow(radius, 2));
    }

    public double perimeter() {
        return (2 * radius * pi);
    }
    
}
