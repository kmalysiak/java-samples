package pl.coderstrust.new_in_java.java9_interface_private_method;

public interface MyInterface {

    double function(double arg);

    default double getFunctionSquare(double arg) {
        return pow(function(arg), 2);
    }

    default double getNumberSquare(double argument) {
        return pow(argument, 2.0);
    }

    default double getNumberCube(double argument) {
        return pow(argument, 3.0);
    }

    private double pow(double base, double power) {
        if (base != 0 && power != 0) {
            return Math.pow(base, power);
        } else {
            return 0;
        }
    }
}