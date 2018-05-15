package pl.coderstrust.fibbonaci;

public class IterativeFibbonaci extends FibbonaciCalculator {

  public long calculateFibbonaciNumber(int n) {

    long[] array = new long[n + 2];
    array[0] = ZERO_FIBBONACI_NUMBER;
    array[1] = FIRST_FIBBONACI_NUMBER;

    for (int i = 2; i < n + 1; i++) {
      array[i] = array[i - 1] + array[i - 2];
    }
    return array[n];
  }
}