package pl.coderstrust.challenge.composition;

public class Handle {

    private boolean isOpen;
    private boolean isLocked;

    public Handle(boolean isOpen, boolean isLocked) {
        System.out.println("Handle constructor called!");
        this.isOpen = isOpen;
        this.isLocked = isLocked;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public boolean OpenHandle(){
        boolean status;
        if (!isLocked) {
            System.out.println("Opening handle...");
            status = true;
            this.isOpen = true;
        }else{
            System.out.println("Cannot open - handle is Locked!");
            status = false;
        }

        return status;
    }

    public void CloseHandle(){
        System.out.println("Handle: Closing handle...");
        this.isOpen = false;

    }


    private void LockHandle(){
        System.out.println("Handle: Locking handle");
    }

    private void UncloskHandle(){
        System.out.println("Handle: Unlocking handle");
    }
}
