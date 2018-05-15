package pl.coderstrust.sortperformance;

import java.util.Arrays;

public class QuickSort implements SortingMethod {
    int output[];

    public int[] sort(int[] input) {
        output = Arrays.copyOf(input, input.length);
        int length = output.length;
        quickSort(0, length - 1);
        return output;
    }

    private void quickSort(int low, int high) {
        int i = low;
        int j = high;
        int pivot = output[low + (high - low) / 2];
        while (i <= j) {
            while (output[i] < pivot) {
                i++;
            }
            while (output[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }
        if (low < j) {
            quickSort(low, j);
        }
        if (i < high) {
            quickSort(i, high);
        }
    }

    private void swap(int i, int j) {
        int temp = output[i];
        output[i] = output[j];
        output[j] = temp;
    }
}
