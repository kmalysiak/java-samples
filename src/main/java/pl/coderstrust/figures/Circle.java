package pl.coderstrust.figures;

public class Circle implements Aerable {
    private double radius = 0d;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return radius * radius * Math.PI;
    }
}
