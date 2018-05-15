package pl.coderstrust.challenge.inheritance;

public class FourWheelsCar extends Car {
    private boolean fourWheelsDriveOn;

    public FourWheelsCar(boolean fourWheelsDriveOn) {
        super();
        this.fourWheelsDriveOn = fourWheelsDriveOn;
        System.out.println("4 wheels car constructor called");
    }
}
