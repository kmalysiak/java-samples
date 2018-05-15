package pl.coderstrust.figures;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class RectangleTest {

    @Test
    public void shouldReturnCorrectAreaOfRandomRectangle() {
        double comparisonPrecision = 1e-6;
        Random random = new Random();
        double a = random.nextDouble();
        double b = random.nextDouble();
        assertEquals(a * b, new Rectangle(a, b).calculateArea(), comparisonPrecision);
    }

}