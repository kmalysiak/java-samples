package pl.coderstrust.erastotenes;


import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class ErastotenesSieveTest {
    @Test
    public void shouldReturnAllPrimesForCorrectMaxPrimeValue() {
        ErastotenesSieve sieve = new ErastotenesSieve(100);
        int[] result = sieve.getPrimeNumbers();
        int[] expected = generateTruePrimeNumbers(100);
        assertArrayEquals(result, expected);
    }

    private int[] generateTruePrimeNumbers(int maxPrime) {
        List<Integer> primeList = new ArrayList<Integer>();
        for (int i = 0; i < maxPrime; i++) {
            if (BigInteger.valueOf(i).isProbablePrime(100)) {
                primeList.add(i);
            }
        }
        return primeList.stream().mapToInt(Integer::intValue).toArray();
    }

    @Test
    public void shouldDoDefaultForIncorrectmaxPrime() {
        ErastotenesSieve sieve = new ErastotenesSieve(-1);
        int[] result = sieve.getPrimeNumbers();
        int[] expected = new int[]{2};
        assertArrayEquals(result, expected);
    }
}