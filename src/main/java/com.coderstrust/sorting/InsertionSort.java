package com.coderstrust.sorting;

public class InsertionSort implements Sortable {

  @Override
  public void sort(Integer[] array) {
    if (array.length == 0) {
      return;
    }
    doSort(array);
  }

  private void doSort(Integer[] array) {
    for (int i = 1; i < array.length; i++) {
      int j = i;
      while (j > 0 && array[j] < array[j - 1]) {
        swapElements(j - 1, j, array);
        j--;
      }
    }
  }
}