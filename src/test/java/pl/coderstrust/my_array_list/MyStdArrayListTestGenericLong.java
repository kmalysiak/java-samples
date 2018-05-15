package pl.coderstrust.my_array_list;

import java.util.ArrayList;
import java.util.List;

public class MyStdArrayListTestGenericLong extends ListTestBaseGeneric<Long> {
    private static TestObjectsGeneratorLong objectGenerator = new TestObjectsGeneratorLong();

    public List getList() {
        return new ArrayList<Long>();
    }

    public Long getTestObject(int index) {
        return objectGenerator.getTestObject(index);
    }
}