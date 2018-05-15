package pl.coderstrust.search;

public class BinarySearch implements Search {
    public int search(int[] array, int element) {
        int lowIndex = 0;
        int highIndex = array.length - 1;
        boolean success = false;
        int indexFound = -1;

        while ((lowIndex <= highIndex) && !success) {
            int mid = lowIndex + (highIndex - lowIndex) / 2;
            if (element > array[mid]) {
                lowIndex = mid + 1;
            } else {
                if (element < array[mid]) {
                    highIndex = mid - 1;
                } else {
                    success = true;
                    indexFound = mid;
                }
            }
        }
        return indexFound;
    }
}
