package pl.coderstrust.figures;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class SquareTest {

    @Test
    public void shouldReturnCorrectAreaOfRandomSquare() {
        double comparisonPrecision = 1e-6;
        Random random = new Random();
        double a = random.nextDouble();
        assertEquals(a * a, new Square(a).calculateArea(), comparisonPrecision);

    }

}