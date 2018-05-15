package pl.coderstrust.erastotenes;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ErastotenesSieve sieve = new ErastotenesSieve(123);
        int primeNumber[] = sieve.getPrimeNumbers();
        System.out.println("Prime numbers found:");
        System.out.println(Arrays.toString(primeNumber));
    }
}

