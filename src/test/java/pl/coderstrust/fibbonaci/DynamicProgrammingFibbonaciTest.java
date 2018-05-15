package pl.coderstrust.fibbonaci;

public class DynamicProgrammingFibbonaciTest extends FibbonaciTest {

  @Override
  public FibbonaciCalculator getCalculator() {
    return new DynamicProgrammingFibbonaci();
  }
}
