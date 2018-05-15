package pl.coderstrust.my_array_list;

import java.util.List;

public class MyArrayListTestGenericString extends ListTestBaseGeneric<String> {
    private static TestObjectsGeneratorString objectGenerator = new TestObjectsGeneratorString();

    public List getList() {
        return new MyArrayList<String>();
    }

    public String getTestObject(int index) {
        return objectGenerator.getTestObject(index);
    }
}