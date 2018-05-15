package pl.coderstrust.new_in_java.java8_lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        //simple lambda
        NumericTest isEven = (n) -> (n % 2) == 0;
        System.out.println(isEven.makeTest(5));
        System.out.println(isEven.makeTest(4));

        //block lambda
        NumericTest isPrime = (n) -> {
            if (n > 2 && (n & 1) == 0)
                return false;
            for (int i = 3; i * i <= n; i += 2) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        };
        System.out.println(isPrime.makeTest(11));
        System.out.println(isPrime.makeTest(11938390));

        //lambda in iteration as Consumer
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        numbers.forEach(value -> System.out.println(value));

        //lambda as predicate in function argument
        System.out.println(multiplySelected(numbers, n -> n > 2));
        System.out.println(multiplySelected(numbers, n -> n < 2));
        System.out.println(multiplySelected(numbers, n -> isPrime.makeTest(n)));
    }

    private static int multiplySelected(List<Integer> numbers, Predicate<Integer> p) {
        int result = 1;
        for (int number : numbers) {
            if (p.test(number)) {
                result *= number;
            }
        }
        return result;
    }
}

