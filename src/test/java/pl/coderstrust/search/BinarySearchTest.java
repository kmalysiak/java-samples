package pl.coderstrust.search;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinarySearchTest {
    private static BinarySearch binarySearch;

    @BeforeClass
    public static void initializeObjects() {
        binarySearch = new BinarySearch();
    }

    @Test
    public void shouldReturnNegOneForEmptyArray() {
        int[] testArray = new int[0];
        assertEquals(binarySearch.search(testArray, 1), -1);

    }

    @Test
    public void shouldReturnNegOneIfElementNotFound() {
        int[] testArray = new int[]{-1, 0, 1, 2, 3, 4, 6, 7, 8};
        assertEquals(binarySearch.search(testArray, 5), -1);

    }

    @Test
    public void shouldReturnCorrectIndexIfElementFound() {
        int[] testArray = new int[]{-1, 0, 1, 2, 3, 4, 6, 7, 8};
        assertEquals(binarySearch.search(testArray, 1), 2);

    }
}
