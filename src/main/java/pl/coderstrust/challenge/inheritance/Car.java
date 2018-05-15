package pl.coderstrust.challenge.inheritance;

public class Car extends Vehicle {
    private int gear;

    public Car(){
        this(0,0,0);
        System.out.println("Car no parames constructor called");
    }

    private Car(double speed, double angleMove, int gear) {
        super(speed, angleMove);
        this.gear = gear;
        System.out.println("Car full constructor called");

    }

    public void gearUp(int up){
        gear += up;
        System.out.println("Car Gear is: " + this.gear);
    }

    public void gearDown(int down){
        gear -= down;
        System.out.println("Car Gear is: " + this.gear);
    }

}
