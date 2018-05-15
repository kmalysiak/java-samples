package pl.coderstrust.hash_map;

import java.util.HashMap;
import java.util.Map;

public class StdHashMapTest extends HashMapTestBase{

    @Override
    public Map getMap() {
        return new HashMap<String,String>();
    }
}
