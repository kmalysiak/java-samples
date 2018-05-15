package pl.coderstrust.sort;

public class BubbleSort {
    public static int[] sort(int[] array) {
        int[] output = array.clone();
        boolean sorted;
        int sortLength = output.length - 1;
        do {
            sorted = true;
            for (int j = 0; j < sortLength; j++) {
                if (output[j] > output[j + 1]) {
                    int temp = output[j];
                    output[j] = output[j + 1];
                    output[j + 1] = temp;
                    sorted = false;
                }
            }
            sortLength--;
        } while (!sorted);
        return output;
    }
}
