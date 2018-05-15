package pl.coderstrust.sort;

public class InsertionSort {
    public static int[] sort(int[] array) {
        int[] output = array.clone();
        boolean foundPos;
        int j;
        for (int i = 0; i < array.length; i++) {
            int checkedNum = output[i];
            j = i;
            foundPos = false;
            while (!foundPos && j > 0) {
                if (checkedNum < output[j - 1]) {
                    output[j] = output[j - 1];
                    j--;
                } else {
                    foundPos = true;
                }
            }
            output[j] = checkedNum;
        }
        return output;
    }
}
