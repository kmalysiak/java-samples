package pl.coderstrust.erastotenes;

import java.util.Arrays;

public class ErastotenesSieve {
    private int maxPrimeValue;
    private boolean[] prime;
    private int maxPrimeDefault = 2;
    private int[] primeNumbers;
    private int primeNumbersCounter;

    public ErastotenesSieve(int maxPrimeValue) {
        validateMaxPrimeNum(maxPrimeValue);
        initializePrime();
    }

    private void validateMaxPrimeNum(int maxPrimeNum) {
        if (maxPrimeNum >= 2) {
            this.maxPrimeValue = maxPrimeNum;
        } else {
            System.out.println("Input invalid. Default max prime value set to 2");
            this.maxPrimeValue = this.maxPrimeDefault;
        }
    }

    private void initializePrime() {
        prime = new boolean[this.maxPrimeValue + 1];
        Arrays.fill(prime, Boolean.TRUE);
        prime[0] = false;
        prime[1] = false;
    }

    public int[] getPrimeNumbers() {
        calculatePrimeNumbers();
        primeNumbers = new int[primeNumbersCounter - 1];
        int j = 0;
        for (int i = 0; i < prime.length; i++) {
            if (prime[i]) {
                primeNumbers[j] = i;
                j++;
            }
        }
        return primeNumbers;
    }

    private void calculatePrimeNumbers() {
        primeNumbersCounter = maxPrimeValue;
        double scanBound = Math.sqrt((double) prime.length);
        for (int i = 2; i <= scanBound; i++) {
            for (int j = i * i; j < prime.length; j += i) {
                if (prime[j]) {
                    primeNumbersCounter--;
                }
                prime[j] = false;
            }
        }
    }
}