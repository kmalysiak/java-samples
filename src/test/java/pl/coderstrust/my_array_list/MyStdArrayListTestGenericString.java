package pl.coderstrust.my_array_list;

import java.util.ArrayList;
import java.util.List;

public class MyStdArrayListTestGenericString extends ListTestBaseGeneric<String> {
    private static TestObjectsGeneratorString objectGenerator = new TestObjectsGeneratorString();

    public List getList() {
        return new ArrayList<Long>();
    }

    public String getTestObject(int index) {
        return objectGenerator.getTestObject(index);
    }
}