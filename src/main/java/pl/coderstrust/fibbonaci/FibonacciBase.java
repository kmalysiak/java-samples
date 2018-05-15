package pl.coderstrust.fibbonaci;

public abstract class FibonacciBase {
    private int ValidWhichFibNum;
    private int whichFibNumDefault = 1;
    private int fibNum;


    public int getFibonacciNumber(int RawWhichFibNum) {
        ValidWhichFibNum = validateFibNum(RawWhichFibNum);
        generateFibNum();
        return fibNum;
    }

    private int validateFibNum(int whichFibNum) {
        if (whichFibNum < 0) {
            return whichFibNumDefault;
        } else {
            return whichFibNum;
        }
    }

    protected abstract void generateFibNum();

    protected int getValidWhichFibNum() {
        return ValidWhichFibNum;
    }

    protected void setFibNum(int fibNum) {
        this.fibNum = fibNum;
    }


}