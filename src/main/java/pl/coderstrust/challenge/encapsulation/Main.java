package pl.coderstrust.challenge.encapsulation;

public class Main {

    public static void main(String[] args) {
        // write your code here


        Printer printer1 = new Printer("HP", 1000, true);
        printer1.refill(100);
        printer1.printpages(1000);
        printer1.refill(203);
        printer1.printpages(10);
        printer1.printpages(10);
        printer1.printpages(10);
        printer1.printpages(10);
        printer1.printpages(10);
        printer1.printpages(10);
        printer1.printpages(10);
        printer1.printpages(10);
        printer1.printpages(10);





        System.out.println(printer1.getTonerLevel());
        System.out.println(printer1.getTotalPagesPrinted());
    }

}

