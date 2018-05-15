package pl.coderstrust.inheritance;

public class Dog extends Animal {

    private int eyes;
    private int legs;
    private int tail;
    private int teeth;
    private String coat;



    public Dog(String name, int size, int weight, int eyes, int legs, int tail, int teeth, String coast) {
        super(name, 1, 1, size, weight);
        this.eyes = eyes;
        this.legs = legs;
        this.tail = tail;
        this.teeth = teeth;
        this.coat = coat;
    }

    private void chew() {
        System.out.println("Chew");
    }

    @Override
    public void eat() {
        System.out.println("dog.eat() called");
        this.chew();
        super.eat();
    }

    public void walk(){
        System.out.println("Dog.walk called");
        super.move(5);
}

    public void run(){
        System.out.println("Dog.run called");
        move(10);
    }
    private void moveLegs(int speeed){
        System.out.println("Dog.MoveLegs called ");
    }

    @Override
    public void move(int speed) {
        System.out.println("Dog.move called");
        moveLegs(speed);
        super.move(speed);
    }
}
