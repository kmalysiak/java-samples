package pl.coderstrust.hash_map;

import java.util.Map;

public class MyHashMapTest extends HashMapTestBase {

    @Override
    public Map getMap() {
        return new MyHashMap<String,String>();
    }
}
