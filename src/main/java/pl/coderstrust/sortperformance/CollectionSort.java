package pl.coderstrust.sortperformance;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionSort implements SortingMethod {
    public int[] sort(int[] array) {
        List<Integer> arrayListToSort = new ArrayList<>(Arrays.asList(ArrayUtils.toObject(array)));
        Collections.sort(arrayListToSort);
        return ArrayUtils.toPrimitive(arrayListToSort.toArray(new Integer[arrayListToSort.size()]));
    }
}
