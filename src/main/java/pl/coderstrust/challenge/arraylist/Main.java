package pl.coderstrust.challenge.arraylist;

public class Main {

    public static void main(String[] args) {
	// write your code here

        MobilePhone mojTelefon = new MobilePhone();
        mojTelefon.addNewContact("Janek","111");
        mojTelefon.addNewContact("Marek","144");
        mojTelefon.addNewContact("Staszek","123");
        mojTelefon.addNewContact("Janek","111");
        mojTelefon.printContactList();

        mojTelefon.removeExistingContact("Janek");
        mojTelefon.updateExistingContactPhone("Janek","333");
        mojTelefon.updateExistingContactPhone("Marek","345");
        mojTelefon.printContactList();
        mojTelefon.callExistingContact("Marek ");
        mojTelefon.showExistingContact("Janek");


        //it slows gdown as each time need check if contact exist
        RandomString gen = new RandomString(2);

        for(int i=0; i<1e2;i++){
            mojTelefon.addNewContact(gen.nextString(),gen.nextString());
        }



    }
}
