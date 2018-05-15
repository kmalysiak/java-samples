package com.coderstrust.sorting;

public class SelectionSortTest extends SortingTestBase {

  @Override
  public Sortable getSortingImplementation() {
    return new SelectionSort();
  }
}
