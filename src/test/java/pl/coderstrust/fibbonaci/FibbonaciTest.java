package pl.coderstrust.fibbonaci;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public abstract class FibbonaciTest {

  private static final int DEFAULT_TEST_CASES_COUNT = 93;
  private FibbonaciCalculator calculator;

  public abstract FibbonaciCalculator getCalculator();

  public int getTestCasesCount() {
    return DEFAULT_TEST_CASES_COUNT;
  }

  @Before()
  public void initializeCalculator() {
    calculator = getCalculator();
  }

  @Test
  @Parameters({
      "-1",
      "93"})
  public void shouldReturnErrorFlagForIncorrectIndex(int fibbonaciIndex) {
    //given
    long result;
    //when
    result = getCalculator().getFibbonaciNumber(fibbonaciIndex);
    //then
    assertThat(result, is(-1L));
  }

  @Test
  @Parameters(method = "getTestData")
  public void shouldReturnCorrectFibbonaciNumber(int number, long expectedFibbonaciNumber) {
    //given
    long result;
    //when
    result = calculator.getFibbonaciNumber(number);
    //then
    assertThat(result, is(expectedFibbonaciNumber));
  }

  public Object[][] getTestData() {
    Object[][] fibbonaciNumbers = new Object[getTestCasesCount()][2];
    fibbonaciNumbers[0] = new Object[]{0, 0L};
    fibbonaciNumbers[1] = new Object[]{1, 1L};
    for (int i = 2; i < fibbonaciNumbers.length; i++) {
      fibbonaciNumbers[i] = new Object[]{i,
          (long) fibbonaciNumbers[i - 1][1] + (long) fibbonaciNumbers[i - 2][1]};
    }
    return fibbonaciNumbers;
  }
}