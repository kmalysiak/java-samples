package pl.coderstrust.constructors;



public class Main {

    public static void main(String[] args) {
        BankAccc MyAccount = new BankAccc();

        MyAccount.setAccountNumber(2121212);
        MyAccount.setEmail("test@test.com");
        MyAccount.setNameSurname("John Doe");
        MyAccount.setPhoneNumber("+4878363302654");

        MyAccount.MakeDeposit(3231354.5454d);
        MyAccount.MakeWithdrawal(6546465464646d);
        MyAccount.MakeWithdrawal(1d);

        BankAccc MyAcccount2;

        MyAcccount2 = new BankAccc(4324243, 0, "john doe", "emial", "+48546546");

        BankAccc MyAcc3 = new BankAccc("test@test.pl", "+487936332211");

        pl.coderstrust.constructors.VipCustomer customer1 = new pl.coderstrust.constructors.VipCustomer();
        pl.coderstrust.constructors.VipCustomer customer2 = new pl.coderstrust.constructors.VipCustomer("Jan Kowalski", 0, "jan_kowaslki@wp.pl");
        pl.coderstrust.constructors.VipCustomer customer3 = new pl.coderstrust.constructors.VipCustomer("Jan Kowalski", 0);
    }




}
