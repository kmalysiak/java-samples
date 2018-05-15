package pl.coderstrust.figures;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class TrapezoidTest {

    @Test
    public void shouldReturnCorrectAreaOfRandomTrapezoid() throws Exception {
        double comparisonPrecision = 1e-6;
        Random random = new Random();
        double a = random.nextDouble();
        double b = random.nextDouble();
        double h = random.nextDouble();
        assertEquals((a + b) / 2.0d * h, new Trapezoid(a, b, h).calculateArea(), comparisonPrecision);
    }
}