package com.coderstrust.sorting;

public class MergeSort implements Sortable {

  @Override
  public void sort(Integer[] array) {
    if (array.length == 0) {
      return;
    }
    doSort(array);
  }

  private void doSort(Integer[] array) {
    mergeSort(array, 0, array.length - 1);
  }

  private void mergeSort(Integer[] array, int leftIndex, int rightIndex) {
    if (leftIndex != rightIndex) {
      int midIndex = (leftIndex + rightIndex) / 2;
      mergeSort(array, leftIndex, midIndex);
      mergeSort(array, midIndex + 1, rightIndex);
      merge(array, leftIndex, midIndex, rightIndex);
    }
  }

  private void merge(Integer[] array, int leftIndex, int midIndex, int rightIndex) {

    Integer[] leftArray = new Integer[midIndex - leftIndex + 2];
    copySelectedArrayElements(array, leftArray, leftIndex, midIndex);
    leftArray[midIndex - leftIndex + 1] = Integer.MAX_VALUE;

    Integer[] rightArray = new Integer[rightIndex - midIndex + 1];
    copySelectedArrayElements(array, rightArray, midIndex + 1, rightIndex);
    rightArray[rightIndex - midIndex] = Integer.MAX_VALUE;

    int i = 0, j = 0;
    for (int k = leftIndex; k <= rightIndex; k++) {
      if (leftArray[i] <= rightArray[j]) {
        array[k] = leftArray[i];
        i++;
      } else {
        array[k] = rightArray[j];
        j++;
      }
    }
  }

  private void copySelectedArrayElements(Integer[] arrayToCopyFrom, Integer[] arrayToCopyIn,
      int startCopyIndex, int endCopyIndex) {
    System.arraycopy(arrayToCopyFrom, startCopyIndex, arrayToCopyIn, 0,
        endCopyIndex - startCopyIndex + 1);
  }
}
