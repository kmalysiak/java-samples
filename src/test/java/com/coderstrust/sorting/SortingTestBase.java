package com.coderstrust.sorting;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;

public abstract class SortingTestBase {

  private static Random random = new Random();

  public abstract Sortable getSortingImplementation();

  private void prepareTestDataSortAndAssert(Integer[] arrayToSort) {

    //given
    Integer[] expectedArray = arrayToSort.clone();
    Arrays.sort(expectedArray);

    //when
    getSortingImplementation().sort(arrayToSort);

    //then
    assertArrayEquals(expectedArray, arrayToSort);
  }

  @Test
  public void shouldSortRevertSortedArray() {
    Integer[] revertSortedArray = new Integer[100];
    for (int i = 0; i < revertSortedArray.length; i++) {
      revertSortedArray[i] = 1_000_000 - i;
    }
    prepareTestDataSortAndAssert(revertSortedArray);
  }

  @Test
  public void shouldSortSortedArray() {
    Integer[] sortedArray = new Integer[1_000];
    for (int i = 0; i < sortedArray.length; i++) {
      sortedArray[i] = -5_000 + i;
    }
    prepareTestDataSortAndAssert(sortedArray);
  }

  @Test
  public void shouldSortRandomNumbersArray3Elements() {
    Integer[] randomNumbersArray1 = new Integer[3];
    for (int i = 0; i < randomNumbersArray1.length; i++) {
      randomNumbersArray1[i] = random.nextInt();
    }
    prepareTestDataSortAndAssert(randomNumbersArray1);
  }

  @Test
  public void shouldSortRandomNumbersArray50elements() {
    Integer[] randomNumbersArray2 = new Integer[50];
    for (int i = 0; i < randomNumbersArray2.length; i++) {
      randomNumbersArray2[i] = random.nextInt();
    }
    prepareTestDataSortAndAssert(randomNumbersArray2);
  }

  @Test
  public void shouldSortRandomNumbersArray1000elements() {
    Integer[] randomNumbersArray3 = new Integer[1000];
    for (int i = 0; i < randomNumbersArray3.length; i++) {
      randomNumbersArray3[i] = random.nextInt();
    }
    prepareTestDataSortAndAssert(randomNumbersArray3);
  }

  @Test
  public void shouldSortNegativeNumbersArray() {
    Integer[] negativeNumbersArray = new Integer[600];
    for (int i = 0; i < negativeNumbersArray.length; i++) {
      negativeNumbersArray[i] = -random.nextInt(Integer.MAX_VALUE);
    }
    prepareTestDataSortAndAssert(negativeNumbersArray);
  }

  @Test
  public void shouldSortpositiveNumbersArray() {
    Integer[] positiveNumberArray = new Integer[100];
    for (int i = 0; i < positiveNumberArray.length; i++) {
      positiveNumberArray[i] = random.nextInt(Integer.MAX_VALUE);
    }
    prepareTestDataSortAndAssert(positiveNumberArray);
  }

  @Test
  public void shouldSortBigNumbersArray() {
    Integer[] bigNumbersArray = new Integer[999];
    for (int i = 0; i < bigNumbersArray.length; i++) {
      bigNumbersArray[i] = Integer.MAX_VALUE - random.nextInt(1_000_000);
    }
    prepareTestDataSortAndAssert(bigNumbersArray);
  }

  @Test
  public void shouldSortLowNumbersArray() {
    Integer[] lowNumbersArray = new Integer[1_000];
    for (int i = 0; i < lowNumbersArray.length; i++) {
      lowNumbersArray[i] = -(Integer.MAX_VALUE - random.nextInt(1_000_000));
    }
    prepareTestDataSortAndAssert(lowNumbersArray);
  }

  @Test
  public void ShouldSortArrayWithManyDuplicates() {
    Integer[] duplicatesArray = new Integer[5_000];
    for (int i = 0; i < duplicatesArray.length; i++) {
      duplicatesArray[i] = random.nextInt(100);
    }
    prepareTestDataSortAndAssert(duplicatesArray);
  }

  @Test
  public void ShouldSortEmptyArray() {
    Integer[] emptyArray = {};
    prepareTestDataSortAndAssert(emptyArray);
  }

  @Test
  public void ShouldSortOneElementArray() {
    Integer[] oneElementArray = {5};
    prepareTestDataSortAndAssert(oneElementArray);
  }
}