package pl.coderstrust.sort;

public class Main {
    public static void main(String[] args) {
        int[] unsorted = new int[]{101, 3, 1, 4, 2, 2, 1, 6, -1, -2, 100, -212};
        int[] bubbleSorted = pl.coderstrust.sort.BubbleSort.sort(unsorted);
        System.out.println("Bubble sorted");
        for (int i = 0; i < bubbleSorted.length; i++) {
            System.out.println(bubbleSorted[i]);
        }
        int[] insertSorted = pl.coderstrust.sort.InsertionSort.sort(unsorted);
        System.out.println("Insertion sorted");
        for (int i = 0; i < insertSorted.length; i++) {
            System.out.println(insertSorted[i]);
        }
    }
}
