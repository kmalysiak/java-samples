package pl.coderstrust.fibbonaci;

public class RecursiveFibbonaciTest extends FibbonaciTest {

  private static final int LIMITED_TEST_CASES_COUNT = 41;

  @Override
  public FibbonaciCalculator getCalculator() {
    return new RecursiveFibbonaci();
  }

  @Override
  public int getTestCasesCount() {
    return LIMITED_TEST_CASES_COUNT;
  }
}