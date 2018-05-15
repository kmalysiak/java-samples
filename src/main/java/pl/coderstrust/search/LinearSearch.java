package pl.coderstrust.search;

public class LinearSearch implements Search {

    public int search(int[] array, int element) {
        boolean success = false;
        int indexFound = -1;

        for (int i = 0; (i < array.length) && !success; i++) {
            if (array[i] == element) {
                success = true;
                indexFound = i;
            }
        }
        return indexFound;
    }
}
