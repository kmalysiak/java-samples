package pl.coderstrust.figures;

public class Trapezoid implements Aerable {
    private double a = 0d;
    private double b = 0d;
    private double h = 0d;

    public Trapezoid(double a, double b, double h) {
        this.a = a;
        this.b = b;
        this.h = h;
    }

    public double calculateArea() {
        return (a + b) / 2.0d * h;
    }
}
