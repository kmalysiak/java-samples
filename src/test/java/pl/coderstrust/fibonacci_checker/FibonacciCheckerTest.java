package pl.coderstrust.fibonacci_checker;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class FibonacciCheckerTest {
    private static FibonacciChecker fibonacciChecker;

    @BeforeClass
    public static void initializeObjects() {
        fibonacciChecker = new FibonacciChecker();
    }

    @Test
    @Parameters({
            "1,true",
            "2,true",
            "4,false",
            "5,true",
            "10,false",
            "13,true",
            "15,false",
    })
    public void shouldCorrectlyCheckFibonacciNumbers(long number, boolean isFibonacciNum) {
        assertEquals(fibonacciChecker.isFibbonaciNumber(number), isFibonacciNum);
    }
}

