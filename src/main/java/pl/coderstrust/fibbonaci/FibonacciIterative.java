package pl.coderstrust.fibbonaci;

public class FibonacciIterative extends FibonacciBase {

    public FibonacciIterative() {
        super();
    }

    public void generateFibNum() {
        int prePred = 0;
        int pred = 1;
        int fibInterim = 0;
        for (int i = 0; i < super.getValidWhichFibNum(); i++) {
            prePred = pred;
            pred = fibInterim;
            fibInterim = pred + prePred;
        }
        setFibNum(fibInterim);
    }
}