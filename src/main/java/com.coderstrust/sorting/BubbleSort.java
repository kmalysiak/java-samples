package com.coderstrust.sorting;

public class BubbleSort implements Sortable {

  @Override
  public void sort(Integer[] array) {
    if (array.length == 0) {
      return;
    }
    doSort(array);
  }

  private void doSort(Integer[] array) {
    boolean wasSwapped = true;
    int sortingRange = array.length - 1;
    while (wasSwapped) {
      wasSwapped = false;
      for (int i = 0; i < sortingRange; i++) {
        if (array[i + 1] < array[i]) {
          swapElements(i, i + 1, array);
          wasSwapped = true;
        }
      }
      --sortingRange;
    }
  }
}
