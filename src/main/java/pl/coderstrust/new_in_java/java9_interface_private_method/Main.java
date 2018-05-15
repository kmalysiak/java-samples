package pl.coderstrust.new_in_java.java9_interface_private_method;

public class Main implements MyInterface {
    public static void main(String[] args) {
        Main powerCalc = new Main();
        System.out.println(powerCalc.getNumberSquare(2));
        System.out.println(powerCalc.getNumberCube(4));
        System.out.println(powerCalc.getFunctionSquare(Math.PI / 4.0d));
    }

    public double function(double arg) {
        return Math.asin(arg);
    }
}
