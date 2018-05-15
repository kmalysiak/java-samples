package pl.coderstrust.challenge.composition;

public class Window {

    private boolean isOpen;
    private Handle handle;

    public Window(boolean isOpen, Handle handle) {
        System.out.println("Window constructor called");
        this.isOpen = isOpen;
        this.handle = handle;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public Handle getHandle() {
        return handle;
    }

    public void OpenWindow() {
        if (this.handle.OpenHandle()) {
            System.out.println("Window: Opening window");
            this.isOpen = true;
        } else {
            System.out.println("Window: Opening not sucessful");
        }

    }

    public void CloseWindow(){
        this.isOpen = false;
        System.out.println("Window: Closing window");
    }

}
