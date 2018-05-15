package com.coderstrust.sorting;

public class HeapSortTest extends SortingTestBase {

  @Override
  public Sortable getSortingImplementation() {
    return new HeapSort();
  }
}
