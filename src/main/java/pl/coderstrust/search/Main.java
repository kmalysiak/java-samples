package pl.coderstrust.search;

import java.util.Random;

import static java.lang.System.nanoTime;

public class Main {
    public static void main(String[] args) {
        LinearSearch linearSearch = new LinearSearch();
        BinarySearch binarySearch = new BinarySearch();

        int arraySize = 1000000;
        int numberOfRepetitions = 1000;
        double durationBin = 0d;
        double durationLin = 0d;
        int sampleArray[] = fillArray(arraySize);
        for (int i = 0; i < numberOfRepetitions; i++) {
            int randomNumberToSearch = getRandomNumberToSearch(arraySize);
            long duration = getExecutionTime(linearSearch, sampleArray, randomNumberToSearch);
            durationLin += ((double) duration) / ((double) numberOfRepetitions);
            duration = getExecutionTime(binarySearch, sampleArray, randomNumberToSearch);
            durationBin += ((double) duration) / ((double) numberOfRepetitions);
        }
        System.out.printf("Average binary search time :%2f [ms]" + System.lineSeparator(), durationBin / 1e6d);
        System.out.printf("Average linear search time :%2f [ms]", durationLin / 1e6d);
    }

    private static int[] fillArray(int size) {
        int[] sampleArray = new int[size];
        for (int i = 0; i < sampleArray.length; i++) {
            sampleArray[i] = i;
        }
        return sampleArray;
    }

    private static int getRandomNumberToSearch(int upper) {
        Random randNumGenerator = new Random();
        return (randNumGenerator.nextInt(upper));
    }

    private static long getExecutionTime(Search search, int[] sampleArray, int numberToSearch) {
        long startTime = nanoTime();
        search.search(sampleArray, numberToSearch);
        long endTime = System.nanoTime();
        return (endTime - startTime);
    }
}

