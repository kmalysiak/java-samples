package pl.coderstrust.figures;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CircleTest {
    private double comparisonPrecision = 1e-6;

    @Test
    public void shouldReturnPiForRadiusOne() {
        assertEquals(Math.PI, new Circle(1d).calculateArea(), comparisonPrecision);
    }

    @Test
    public void shouldReturnCorrectAreaOfCircle() {
        assertEquals(Math.PI * 5d, new Circle(Math.sqrt(5)).calculateArea(), comparisonPrecision);

    }
}