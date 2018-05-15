package com.coderstrust.sorting;

public interface Sortable {

  void sort(Integer[] array);

  default void swapElements(int indexElement1, int indexElement2, Integer[] array) {
    int temp = array[indexElement1];
    array[indexElement1] = array[indexElement2];
    array[indexElement2] = temp;
  }
}
