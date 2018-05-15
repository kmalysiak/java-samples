package pl.coderstrust.my_array_list;

import java.util.List;

public class MyArrayListTestGenericLong extends ListTestBaseGeneric<Long> {
    private static TestObjectsGeneratorLong objectGenerator = new TestObjectsGeneratorLong();

    public List getList() {
        return new MyArrayList<Long>();
    }

    public Long getTestObject(int index) {
        return objectGenerator.getTestObject(index);
    }
}