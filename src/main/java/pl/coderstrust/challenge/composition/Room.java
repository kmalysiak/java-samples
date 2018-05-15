package pl.coderstrust.challenge.composition;

public class Room {
    private Window window1;
    public Window window2;

    public Window getWindow1() {
        return window1;
    }

    public Window getWindow2() {
        return window2;
    }

    public Room(Window window1, Window window2) {
        System.out.println("Room constructor called!");
        this.window1 = window1;
        this.window2 = window2;
    }
}
