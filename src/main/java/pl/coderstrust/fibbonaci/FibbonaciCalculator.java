package pl.coderstrust.fibbonaci;

public abstract class FibbonaciCalculator {

  protected static final long ZERO_FIBBONACI_NUMBER = 0L;
  protected static final long FIRST_FIBBONACI_NUMBER = 1L;
  protected static final long INVALID_INDEX_FLAG = -1L;
  protected static final int MIN_FIBBONACI_NUMBER_INDEX = 0;
  protected static final int MAX_FIBBONACI_NUMBER_INDEX = 92;

  public long getFibbonaciNumber(int n) {
    if (n < MIN_FIBBONACI_NUMBER_INDEX) {
      return INVALID_INDEX_FLAG;
    }
    if (n > MAX_FIBBONACI_NUMBER_INDEX) {
      // "Result out of type LONG range"
      return INVALID_INDEX_FLAG;
    }
    return calculateFibbonaciNumber(n);
  }

  protected abstract long calculateFibbonaciNumber(int n);
}