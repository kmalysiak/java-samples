package pl.coderstrust.challenge.encapsulation;

public class Printer {

    private String printerName;
    private int totalPagesPrinted;
    private double tonerLevel;
    private boolean isDuplex;
    private double tonerPerPage;


    public Printer(String printerName, double tonerLevel, boolean isDuplex){
        this(printerName, 0,tonerLevel,isDuplex, 0.1d);
    }

    private Printer(String printerName, int pagesPrinted, double tonerLevel, boolean isDuplex, double tonerPerPage) {

        if(tonerLevel <0 && tonerLevel >100){
            tonerLevel = 0;
            System.out.println("Toner level set to default" + tonerLevel);

        }

        this.printerName = printerName;
        this.totalPagesPrinted = pagesPrinted;
        this.tonerLevel = tonerLevel;
        this.isDuplex = isDuplex;
        this.tonerPerPage = tonerPerPage;
    }

    public void refill(double refillQuantity){
        if (this.tonerLevel + refillQuantity >100){
            this.tonerLevel = 100;
        }else{
                this.tonerLevel += refillQuantity;
    }
        System.out.println("Toner refilled to level " + this.tonerLevel);
    }

    public void printpages(int numberOfPages){
        int actuallyPrinted;
        double tonerNeeded = numberOfPages *this.tonerPerPage ;

        System.out.println("Is printer duplex:" + this.isDuplex);

        if(tonerNeeded > this.tonerLevel) {
            actuallyPrinted = (int) ((double) this.tonerLevel / this.tonerPerPage);
            System.out.println("Will print only" + actuallyPrinted + " pages due to tonner limitation");
            this.totalPagesPrinted += actuallyPrinted;
            this.tonerLevel = 0;
        }else{
            System.out.println("Printing whole document");
            this.totalPagesPrinted+=numberOfPages;
            this.tonerLevel -= (numberOfPages* this.tonerPerPage);
        }

    }

    public int getTotalPagesPrinted() {
        return totalPagesPrinted;
    }

    public double getTonerLevel() {
        return tonerLevel;
    }
}
