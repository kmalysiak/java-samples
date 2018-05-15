package pl.coderstrust.figures;

public class Triangle implements Aerable {
    private double a = 0d;
    private double h = 0d;

    public Triangle(double a, double h) {
        this.a = a;
        this.h = h;
    }

    public double calculateArea() {
        return 0.5d * a * h;
    }
}
