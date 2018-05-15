package pl.coderstrust.constructors;

public class BankAccc {

    private int accountNumber;
    private double balance;
    private String NameSurname;
    private String email;
    private String PhoneNumber;

    public BankAccc(){

        this(0,0,"John Doe","none","none");
        System.out.println("Empty constructor");
    }

    public BankAccc(int accountNumber, double balance, String NameSurname, String email, String PhoneNumber){
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.NameSurname = NameSurname;
        this.email = email;
        this.PhoneNumber = PhoneNumber;

        System.out.println("Acc. constructor with params called");
    }



    public BankAccc(String email, String phoneNumber) {

        this(1010101,0,"none",email,phoneNumber);
    }

    public void setAccountNumber(int AccountNumber){
        this.accountNumber = AccountNumber;
    }


    public  void setBalance(double balance){
        this.balance = balance;
    }

    public void setNameSurname(String NameSurname){
        this.NameSurname = NameSurname;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPhoneNumber(String PhoneNumber){
        this.PhoneNumber = PhoneNumber;
    }

    public int getAccountNumber(){
        return accountNumber;
    }
    public double geBalance(){
        return balance;
    }

    public String getNameSurname(){
        return NameSurname;
    }
    public String getEmail(){
        return email;
    }
    public String getPhoneNumber(){
        return PhoneNumber;
    }

    public void MakeDeposit(double amount)
    {
        if(amount>= 0){
            this.balance+=amount;
            System.out.println("Balance account after deposit:" + this.balance);
        } else {
            System.out.println("Incorrect amount input at deposit");
        }
    }
    public void MakeWithdrawal(double amount)
    {
        if(amount >= 0 && amount <= this.balance){
            this.balance-=amount;
            System.out.println("Balance account after withdrawawl:" + this.balance);
        } else {
            System.out.println("Incorrect amount input or withdrawal exceeds balance");
        }
    }





}
