package pl.coderstrust.figures;

public class Rectangle implements Aerable{
   private double a=0d;
   private double b=0d;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double calculateArea(){
        return a*b;
    }
}
