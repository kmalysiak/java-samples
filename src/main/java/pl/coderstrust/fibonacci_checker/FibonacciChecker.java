package pl.coderstrust.fibonacci_checker;

import java.util.HashSet;
import java.util.Set;

public class FibonacciChecker {
    private Set<Long> cacheIsFibonacci = new HashSet<>();
    private Set<Long> cacheIsNotFibonacci = new HashSet<>();

    public boolean isFibbonaciNumber(long number) {
        boolean isFibonacciNumber = false;
        if (cacheIsFibonacci.contains(number)) {
            isFibonacciNumber = true;
        } else {
            if (!cacheIsNotFibonacci.contains(number)) {
                isFibonacciNumber = isFibonacciAnalyticalTest(number);
                if (isFibonacciNumber) {
                    cacheIsFibonacci.add(number);
                    isFibonacciNumber = true;
                } else {
                    cacheIsNotFibonacci.add(number);
                }
            }
        }
        return isFibonacciNumber;
    }

    private boolean isFibonacciAnalyticalTest(long number) {
        //implements test derived by Gessel at FibonacciQuart.1972,vol.10,p.417
        boolean isFibonacciNumber = false;
        boolean condition1 = isPerfectSquare(5 * number * number + 4);
        boolean condition2 = isPerfectSquare(5 * number * number - 4);
        if (condition1 || condition2) {
            isFibonacciNumber = true;
        }
        return isFibonacciNumber;
    }

    private boolean isPerfectSquare(long x) {
        long s = (long) Math.floor(Math.sqrt(x));
        return (s * s == x);
    }
}
