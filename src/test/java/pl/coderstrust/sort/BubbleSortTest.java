package pl.coderstrust.sort;

import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class BubbleSortTest {

    @Test
    public void shouldReturnArrayOfLengthEqualToInputArrayLength() {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8};
        assertEquals(input.length, BubbleSort.sort(input).length);
    }

    @Test
    public void shouldSortSingleNumberArray() {
        int[] input = {1};
        int[] expected = {1};
        assertArrayEquals(input, expected);
    }

    @Test
    public void shouldSortArrayLargeArray() {
        int[] input = new int[100000];
        for (int i = 0; i < input.length; i++) {
            input[i] = (int) (Math.random() * 1000);
        }
        int[] expected = Arrays.copyOf(input, input.length);
        Arrays.sort(expected);
        assertArrayEquals(BubbleSort.sort(input), expected);
    }

    @Test
    public void shouldSortArrayWithPositiveAndNegativeIntegers() {
        int[] input = new int[10000];
        for (int i = 0; i < input.length; i++) {
            input[i] = (int) (Math.random() * 1000) - 500;
        }
        int[] expected = Arrays.copyOf(input, input.length);
        Arrays.sort(expected);
        assertArrayEquals(BubbleSort.sort(input), expected);
    }
}



