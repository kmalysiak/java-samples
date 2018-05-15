package pl.coderstrust.my_array_list;

import java.util.ArrayList;

public class TestObjectsGeneratorLong {
    private static final int MAX_COUNT_TEST_OBJECTS = 1000000;
    ArrayList<Long> testObjects = new ArrayList<>(MAX_COUNT_TEST_OBJECTS);


    public TestObjectsGeneratorLong() {
        for (int i = 0; i < MAX_COUNT_TEST_OBJECTS; i++) {
            testObjects.add(Long.valueOf(i));
        }
    }

    public Long getTestObject(int i) {
        if (i < MAX_COUNT_TEST_OBJECTS) {
            return testObjects.get(i);
        } else {
            throw new IndexOutOfBoundsException("Requested index:" + i + "should be smaller than" + MAX_COUNT_TEST_OBJECTS);
        }
    }
}