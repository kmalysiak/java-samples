package pl.coderstrust.foobar;

import java.util.stream.IntStream;

public class FooBar {
    private static final int NUMBERS_COUNT = 100;

    public void printFooBar() {
        IntStream.rangeClosed(0, NUMBERS_COUNT).forEach(
                number -> {
                    System.out.print(number);
                        if (number % 3 == 0) {
                            System.out.print(" Foo");
                            if (number % 5 == 0) {
                                System.out.print("Bar");
                            }
                        }else{
                        if (number % 5 == 0) {
                            System.out.print(" Bar");
                        }
                    }
                    System.out.println("");
                }
        );
    }
}
