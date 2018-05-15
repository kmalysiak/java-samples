package pl.coderstrust.figures;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class TriangleTest {

    @Test
    public void shouldReturnCorrectAreaOfRandomTriangle() {
        double comparisonPrecision = 1e-6;
        Random random = new Random();
        double a = random.nextDouble();
        double h = random.nextDouble();
        assertEquals(a * h / 2.0d, new Triangle(a, h).calculateArea(), comparisonPrecision);
    }
}