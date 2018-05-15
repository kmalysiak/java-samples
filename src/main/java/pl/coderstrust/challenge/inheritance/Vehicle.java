package pl.coderstrust.challenge.inheritance;

public class Vehicle {
    private double speed;
    private double angleMove;


    public Vehicle(double speed, double angleMove) {
        this.speed = speed;
        this.angleMove = angleMove;
        System.out.println("Vehicle full constructor called");
    }

    public void move(double speed){
        this.speed = speed;
        System.out.println("Vehicle speed is  = "+ this.speed);
    }

    public void  turnRight(double angle){
        this.angleMove += angle;
        System.out.println("Vehicle angle is: " + this.angleMove);
    }

    public void turnLeft(double angle){
        this.angleMove-=angle;
        System.out.println("Vehicle angle is: " + this.angleMove);
    }


}
