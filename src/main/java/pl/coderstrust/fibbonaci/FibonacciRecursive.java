package pl.coderstrust.fibbonaci;

public class FibonacciRecursive extends FibonacciBase {
    public FibonacciRecursive() {
        super();
    }

    public void generateFibNum() {
        setFibNum(fibRecurs(getValidWhichFibNum()));
    }

    private int fibRecurs(int count) {
        switch (count) {
            case 0:
                return 0;
            case 1:
                return 1;
            default:
                return fibRecurs(count - 1) + fibRecurs(count - 2);
        }
    }
}