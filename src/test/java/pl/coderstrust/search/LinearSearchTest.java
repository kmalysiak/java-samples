package pl.coderstrust.search;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinearSearchTest {

    private static LinearSearch linearSearch;

    @BeforeClass
    public static void initializeObjects() {
        linearSearch = new LinearSearch();
    }

    @Test
    public void shouldReturnNegOneForEmptyArray() {
        int[] testArray = new int[0];
        assertEquals(linearSearch.search(testArray, 1), -1);

    }

    @Test
    public void shouldReturnNegOneIfElementNotFound() {
        int[] testArray = new int[]{-1, 0, 1, 2, 3, 4, 6, 7, 8};
        assertEquals(linearSearch.search(testArray, 5), -1);

    }

    @Test
    public void shouldReturnCorrectIndexIfElementFound() {
        int[] testArray = new int[]{-1, 0, 1, 2, 3, 4, 6, 7, 8};
        assertEquals(linearSearch.search(testArray, 1), 2);

    }

}
