package com.coderstrust.sorting;

public class BubbleSortTest extends SortingTestBase {

  @Override
  public Sortable getSortingImplementation() {
    return new BubbleSort();
  }
}
