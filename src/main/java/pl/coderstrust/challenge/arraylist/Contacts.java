package pl.coderstrust.challenge.arraylist;

public class Contacts {

    private String Name;
    private String phoneNumber;

    public Contacts(String name, String phoneNumber) {
        Name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static Contacts createContact(String name, String phoneNumber){
        return new Contacts(name, phoneNumber);
    }
}
