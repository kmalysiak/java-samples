package pl.coderstrust.fibbonaci;

import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciRecursiveTest {
    @Test
    public void shouldReturnCorrectFibonacciNumbers() {
        FibonacciRecursive fibNumRec = new FibonacciRecursive();
        int[] result = new int[3];
        int[] expected = new int[3];
        int counter = 0;
        for (int i = 1; i <= 5; i += 2) {
            result[counter] = fibNumRec.getFibonacciNumber(i);
            expected[counter] = getFibNumAnalytical(i);
            counter++;
        }
        assertArrayEquals(result, expected);
    }

    private int getFibNumAnalytical(int whichFibNum) {
        //implements the following analytical formula for Fibonacci Numbers:
        //(phi^n/sqrt(5) =0,5), where phi is the golden ratio = (1+sqrt(5))/2
        double phi = (1d + Math.sqrt(5d)) / 2;
        return (int) (Math.floor(Math.pow(phi, whichFibNum) / Math.sqrt(5d) + 0.5d));
    }

    @Test
    public void shouldReturnDefaultForIncorrectInput() {
        FibonacciRecursive fibNumRec = new FibonacciRecursive();

        assertEquals(1, fibNumRec.getFibonacciNumber(-1));
    }
}