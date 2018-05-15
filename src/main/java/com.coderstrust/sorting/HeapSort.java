package com.coderstrust.sorting;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class HeapSort implements Sortable {

  @Override
  public void sort(Integer[] array) {
    if (array.length == 0) {
      return;
    }
    doSort(array);
  }

  private void doSort(Integer[] array) {
    Queue<Integer> queue = new PriorityQueue<>(Arrays.asList(array));
    for (int i = 0; i < array.length; i++) {
      array[i] = queue.poll();
    }
  }
}
