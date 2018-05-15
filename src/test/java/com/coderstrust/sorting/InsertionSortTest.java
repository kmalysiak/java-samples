package com.coderstrust.sorting;

public class InsertionSortTest extends SortingTestBase {

  @Override
  public Sortable getSortingImplementation() {
    return new InsertionSort();
  }
}
