package pl.coderstrust.fibbonaci;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iterative Fibbonaci number generator:");
        FibonacciIterative fibNumIt = new FibonacciIterative();
        for (int i = 1; i <= 5; i += 2) {
            System.out.println("Fib #" + i + " is:" + fibNumIt.getFibonacciNumber(i));
        }
        System.out.println("Recursive Fibbonaci number generator:");
        FibonacciRecursive fibNumRe = new FibonacciRecursive();
        for (int i = 1; i <= 5; i += 2) {
            System.out.println("Fib #" + i + " is:" + fibNumRe.getFibonacciNumber(i));
        }
    }
}