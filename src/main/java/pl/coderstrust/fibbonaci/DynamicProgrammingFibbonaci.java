package pl.coderstrust.fibbonaci;

import java.util.Arrays;

public class DynamicProgrammingFibbonaci extends FibbonaciCalculator {

  private static final long FIBBONACI_NOT_CALCULATED = -1;
  private long[] fibbonaciNumbersCache = new long[MAX_FIBBONACI_NUMBER_INDEX + 1];

  DynamicProgrammingFibbonaci() {
    Arrays.fill(fibbonaciNumbersCache, FIBBONACI_NOT_CALCULATED);
  }

  public long calculateFibbonaciNumber(int n) {
    return doDynamicRecursiveCalculation(n);
  }

  long doDynamicRecursiveCalculation(int n) {
    if (n < 2) {
      return n;
    }
    if (fibbonaciNumbersCache[n] != FIBBONACI_NOT_CALCULATED) {
      return fibbonaciNumbersCache[n];
    }
    return fibbonaciNumbersCache[n] =
        doDynamicRecursiveCalculation(n - 1) + doDynamicRecursiveCalculation(n - 2);
  }
}