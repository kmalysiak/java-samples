package pl.coderstrust.challenge.arraylist;

import java.util.ArrayList;

public class MobilePhone {

    private ArrayList<Contacts> contacts;

    public MobilePhone() {
        this.contacts = new ArrayList<Contacts>();
    }

    public boolean addNewContact(String name, String phoneNumber) {
        if(!ifContactExist(name)){
            contacts.add(Contacts.createContact(name,phoneNumber));
            System.out.println("add: Contact "+ this.contacts.size()+" added:" + name);
            return true;

        }else{
            System.out.println("add: Contact with name " + name+ " already exists");
            return false;
        }

    }

    public boolean removeExistingContact(String name){
        if(ifContactExist(name)){
            int index = contactIndex(name);
            contacts.remove(index);
            System.out.println("rem: Removed contact "+ name);
            return true;
        }else{
            System.out.println("rem: Contact nof found");
            return false;
        }

    }

    public boolean updateExistingContactPhone(String name,String newPhoneNumber){
        if(ifContactExist(name)){
           int index = contactIndex(name);
           contacts.get(index).setPhoneNumber(newPhoneNumber);
            System.out.println("upd:Updated contact "+ name+ " with new new phone number");
            return true;
        }else{
            System.out.println("upd:Contact nof found");
            return false;
        }

    }

    public boolean callExistingContact(String name){
        if(ifContactExist(name)){
            System.out.println("call: Callinig contact: "+name);
            return true;
        }else{
            System.out.println("call: Contact not found");
            return false;
        }

    }

    public void printContactList(){
        String name_current;
        String phone_current;

        System.out.println("print: Contact List:");

        for(int i =0; i<contacts.size();i++){
            name_current = this.contacts.get(i).getName();
            phone_current = this.contacts.get(i).getPhoneNumber();
            System.out.println("    Name: " + name_current + " phone:"+phone_current);

        }

    }

    public boolean showExistingContact(String name){
        if(ifContactExist(name)){
            String nameFound = this.contacts.get(contactIndex(name)).getName();
            String phoneFound = this.contacts.get(contactIndex(name)).getPhoneNumber();
            System.out.println("show: Name: " + nameFound + " phone:"+phoneFound);
            return true;
        }else{
            System.out.println("show:Contact not found");
            return false;
        }

    }

    private int contactIndex(String name){
        int contactIndex = -1;


        for (int i = 0; i < this.contacts.size(); i++) {
            if (this.contacts.get(i).getName() == name) {
                contactIndex = i;
                break;
            }
        }

        return contactIndex;

    }

    private boolean ifContactExist(String name){
        boolean isFound = false;


            for (int i = 0; i < this.contacts.size(); i++) {
                if (this.contacts.get(i).getName() == name) {
                    isFound = true;
                }
            }

        return isFound;


    }
}


