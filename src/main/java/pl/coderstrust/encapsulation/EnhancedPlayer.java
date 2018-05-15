package pl.coderstrust.encapsulation;

public class EnhancedPlayer {
    private String name;
    private int health;

    public EnhancedPlayer(String name, int health) {
        System.out.println("Enhanced player constructor called");
        this.name = name;

        if (health > 0 && health <= 100) {
            this.health = health;
            System.out.println("Player has now " + health + " points");
        } else {
            System.out.println("Incorrect healts passed; initialising to dedault 20");
            this.health = 20;
        }
    }

    public void decreaseHealth(int quantity) {

        if (quantity < this.health) {
            this.health -= quantity;
            System.out.println(this.health + " life left");

        } else {
            System.out.println("Player dead");
            this.health = 0;
        }


    }
}
