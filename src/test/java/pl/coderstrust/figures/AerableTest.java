package pl.coderstrust.figures;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(DataProviderRunner.class)
public class AerableTest {
    private double comparisonPrecision = 1e-6;

    @DataProvider
    public static Object[][] dataProviderFiguresAreas() {
        return new Object[][]{
                {new Circle(3.0), 9.0 * Math.PI},
                {new Rectangle(0.5, 0.4), 0.2},
                {new Square(15.1), 228.01},
                {new Trapezoid(1, 1, 0.5), 0.5},
                {new Triangle(15.0, 12.0), 90.0}
        };
    }

    @Test
    @UseDataProvider("dataProviderFiguresAreas")
    public void shouldReturnCorrectAreaForSampleFigures(Aerable figure, double expectedArea) {
        assertEquals(figure.calculateArea(), expectedArea, comparisonPrecision);
    }
}