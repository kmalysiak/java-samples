package pl.coderstrust.challenge.composition;

public class Main {

    public static void main(String[] args) {

        Handle handle1, handle2;

       // handle1 = new Handle(false, true);
        //handle2 = new Handle(false, true);

        Window  window1 = new Window(false, new Handle(false, true));
        Window window2 = new Window (false, new Handle(false,false));


        Room kitchen = new Room(window1,window2);

        kitchen.getWindow1().CloseWindow();
        System.out.println("Is window open: " + String.valueOf(kitchen.window2.isOpen()));
        System.out.println("Is handle locked: " + String.valueOf(kitchen.getWindow1().getHandle().isLocked()));


    }


}
