package pl.coderstrust.sortperformance;

public class CollectionSortTest extends SortingTestBase {
    public SortingMethod getSortingMethod() {
        return new CollectionSort();
    }
}