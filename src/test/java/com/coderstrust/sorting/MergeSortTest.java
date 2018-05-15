package com.coderstrust.sorting;

public class MergeSortTest extends SortingTestBase {

  @Override
  public Sortable getSortingImplementation() {
    return new MergeSort();
  }
}
