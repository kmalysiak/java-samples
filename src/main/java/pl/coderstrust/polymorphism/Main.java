package pl.coderstrust.polymorphism;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random generator = new Random();


     Car [] staticTable = new Car[1000];
     List<? super Car> longList = new ArrayList<Car>();
        Car temp;

     for (int i =0;i<1000;i++){

         if(generator.nextDouble()>0.5){
             staticTable[i] = new Truck("randomTruck",i,true);
             longList.add( new Truck("randomTruck",i,true));
         }else{
             staticTable[i] = new Jeep("random Jeep", i,true);
             longList.add(new Jeep("random Jeep",i,true));
         }
         staticTable[i].accelerate(generator.nextDouble()*100);
         ((Car) longList.get(i)).accelerate(generator.nextDouble()*100);


     }
    }




}

class Car {
    private String name;
    private  int cylinders;
    private boolean engine;
    private int wheels;

    protected double speed;
    protected boolean isOn;


    public Car(String name, int cylinders){

        this(name, cylinders, true, 4,0,false);
      //  System.out.println("Car intitializer - 2 parameters");
    }

    private Car(String name, int cylinders, boolean engine, int wheels, double speed, boolean isOn) {
       // System.out.println("Car initializer - all parameters");
        this.name = name;
        this.cylinders = cylinders;
        this.engine = engine;
        this.wheels = wheels;
        this.speed = speed;
        this.isOn = isOn;
    }

    public String getName() {
        return name;
    }

    public int getCylinders() {
        return cylinders;
    }

    public boolean isEngine() {
        return engine;
    }

    public int getWheels() {
        return wheels;
    }

    public double getSpeed() {
        return speed;
    }

    public boolean isOn() {
        return isOn;
    }

    public void startEngine(){
        if(this.isOn){
            System.out.println("Car Engine already on");
        } else{
            this.isOn = true;
            System.out.println("Car Engine started");
        }

    }

    public void accelerate(double setSpeed){
        this.speed = setSpeed;
        System.out.println("Car Set speed is now:"+this.speed);

    }

    public void brake(){
        this.speed = 0;
        System.out.println("Car Speeed is now 0");

    }

}

class Truck extends Car{

    private boolean isTrailer;

    public Truck(String name, int cylinders, boolean isTrailer) {
        super(name, cylinders);
        System.out.println("Truck initializer - 2 parameters");
        this.isTrailer = isTrailer;
    }

    public void accelerate(double setSpeed){
        super.speed = setSpeed;
        System.out.println("Truck and trailer speed: " + super.speed);
    }

}

class Jeep extends Car {

    private boolean is4By4On;

    public Jeep(String name, int cylinders, boolean is4By4On) {
        super(name, cylinders);
        this.is4By4On = is4By4On;

    }

    public void accelerate(double setSpeed) {
        this.speed = setSpeed;
        System.out.println("Jeep speed: " + this.speed + " passed to all wheels");
    }
}

class OldTimer extends Car{
    public OldTimer(String name, int cylinders) {
        super(name, cylinders);
    }

    public void brake(){
        this.speed = 0;
        System.out.println("Limo speed is 0 now despite no ABS");
    }
}

