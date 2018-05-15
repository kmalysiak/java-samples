package pl.coderstrust.sortperformance;

import java.util.Arrays;

public class SelectionSort implements SortingMethod {
    public int[] sort(int[] input) {
        int output[] = Arrays.copyOf(input, input.length);

        for (int i = 0; i < output.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < output.length; j++)
                if (output[j] < output[index]) {
                    index = j;
                }
            int smallerNumber = output[index];
            output[index] = output[i];
            output[i] = smallerNumber;
        }
        return output;
    }
}
