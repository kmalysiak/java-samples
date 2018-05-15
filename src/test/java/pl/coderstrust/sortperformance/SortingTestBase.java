package pl.coderstrust.sortperformance;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public abstract class SortingTestBase {
    public abstract SortingMethod getSortingMethod();

    @Test
    public void shouldSortSimpleArray() {
        // given
        int[] given = new int[]{5, 4, 3, 2, 1};
        int[] expected = new int[]{1, 2, 3, 4, 5};
        int[] result = getSortingMethod().sort(given);
        assertArrayEquals(expected, result);
    }

    @Test
    public void shouldReturnArrayOfLengthEqualToInputArrayLength() {
        int[] given = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] result = getSortingMethod().sort(given);
        assertEquals(given.length, result.length);
    }

    @Test
    public void shouldSortSingleNumberArray() {
        int[] given = {1};
        int[] expected = {1};
        assertArrayEquals(getSortingMethod().sort(given), expected);
    }

    @Test
    public void shouldSortArrayWithPositiveAndNegativeIntegers() {
        int[] given = new int[10000];
        for (int i = 0; i < given.length; i++) {
            given[i] = (int) (Math.random() * 1000) - 500;
        }
        int[] expected = Arrays.copyOf(given, given.length);
        Arrays.sort(expected);
        assertArrayEquals(getSortingMethod().sort(given), expected);
    }

    @Test
    public void shouldSortLargeArray() {
        int[] given = new int[1000];
        for (int i = 0; i < given.length; i++) {
            given[i] = (int) (Math.random() * 1000);
        }
        int[] expected = Arrays.copyOf(given, given.length);
        Arrays.sort(expected);
        long startTime = System.currentTimeMillis();
        int[] result = getSortingMethod().sort(given);
        long endTime = System.currentTimeMillis();
        System.out.println("Sorting with " + getSortingMethod().toString() + " takes: " + (endTime - startTime) + " [ns]");
        assertArrayEquals(result, expected);
    }
}
