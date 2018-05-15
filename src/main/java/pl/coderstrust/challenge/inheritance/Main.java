package pl.coderstrust.challenge.inheritance;

public class Main  {

    public static void main(String[] args) {
	// write your code here
        Car exampleCar = new Car();
        FourWheelsCar jeep = new FourWheelsCar(true);
        jeep.gearUp(1);
        jeep.move(3939);
        jeep.turnLeft(10);
        jeep.turnRight(5);
        jeep.move(3);
    }
}
