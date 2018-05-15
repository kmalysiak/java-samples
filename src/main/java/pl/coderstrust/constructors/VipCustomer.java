package pl.coderstrust.constructors;

public class VipCustomer {

    private String name;
    private double creditLimit;
    private String emailAddress;

    public  VipCustomer() {
        this("John Doe", 0d, "john.doe@gmail.com");

    }

    public  VipCustomer(String name, double creditLimit) {
        this(name, creditLimit, "default@wp.com");
    }

    public  VipCustomer(String name, double creditLimit, String emailAddress) {
        this.name = name;
        this.creditLimit = creditLimit;
        this.emailAddress = emailAddress;
        System.out.println("Created: "+this.name+" "+this.emailAddress+" Acc:" + Double.toString(this.creditLimit));
    }




    public String getName() {
        return name;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public String getEmailAddress() {
        return emailAddress;
    }


   }
