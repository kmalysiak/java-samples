package pl.coderstrust.fibbonaci;

public class RecursiveFibbonaci extends FibbonaciCalculator {

  public long calculateFibbonaciNumber(int n) {
    return doRecursiveCalculation(n);
  }

  private long doRecursiveCalculation(int n) {
    if (n == 0) {
      return ZERO_FIBBONACI_NUMBER;
    }
    if (n == 1) {
      return FIRST_FIBBONACI_NUMBER;
    }
    return doRecursiveCalculation(n - 1) + doRecursiveCalculation(n - 2);
  }
}