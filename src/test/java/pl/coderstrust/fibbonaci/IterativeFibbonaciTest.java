package pl.coderstrust.fibbonaci;

public class IterativeFibbonaciTest extends FibbonaciTest {

  @Override
  public FibbonaciCalculator getCalculator() {
    return new IterativeFibbonaci();
  }
}