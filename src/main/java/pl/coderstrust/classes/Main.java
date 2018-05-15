package pl.coderstrust.classes;

public class Main {

    public static void main(String[] args) {
        Car porsche;// = new Car();
        Car holden = new Car();

        porsche = new Car();
        porsche.setModel("922");

        System.out.println(porsche.getModel());
    }
}
