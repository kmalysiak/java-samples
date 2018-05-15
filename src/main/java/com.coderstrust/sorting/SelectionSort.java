package com.coderstrust.sorting;

public class SelectionSort implements Sortable {

  @Override
  public void sort(Integer[] array) {
    if (array.length == 0) {
      return;
    }
    doSort(array);
  }

  private void doSort(Integer[] array) {
    for (int i = 0; i < array.length; i++) {
      int min = array[i];
      int index = i;
      for (int j = i; j < array.length; j++) {
        if (min > array[j]) {
          min = array[j];
          index = j;
        }
      }
      swapElements(i, index, array);
    }
  }
}
