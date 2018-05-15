package pl.coderstrust.hash_map;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public abstract class HashMapTestBase {
    public abstract Map<String, String> getMap();

    private Map<String, String> emptyMap;
    private Map<String, String> initializedMap;
    private int testObjCount = 100;
    private Set<String> keySet;
    private Set<Map.Entry<String, String>> setEntry;
    private Collection<String> values;

    private String generateKey(int i) {
        return "Value of:" + String.valueOf(i);
    }

    private String generateValue(int i) {
        return "Equals: " + String.valueOf(i);
    }

    @Before
    public void initializeTest() {

        emptyMap = getMap();
        initializedMap = getMap();

        keySet = initializedMap.keySet();
        values = initializedMap.values();
        setEntry = initializedMap.entrySet();

        for (int i = 0; i < testObjCount; i++) {
            initializedMap.put(generateKey(i), generateValue(i));
        }
    }

    @Test
    public void shouldPutKeyAndValue() {
        emptyMap.put(generateKey(1), generateValue(1));
        assertEquals(emptyMap.get(generateKey(1)), generateValue(1));
    }

    @Test
    public void shouldPutNevValueToExistingKey() {
        emptyMap.put(generateKey(1), generateValue(1));
        emptyMap.put(generateKey(1), generateValue(2));
        assertEquals(emptyMap.get(generateKey(1)), generateValue(2));
    }

    @Test
    public void shouldPut10000KeyAndValue() {
        int testObjectsCount = 10000;
        String should[] = new String[testObjectsCount];
        String output[] = new String[testObjectsCount];
        for (int i = 0; i < testObjectsCount; i++) {
            should[i] = generateValue(i);
            emptyMap.put(generateKey(i), should[i]);
        }

        for (int i = 0; i < testObjectsCount; i++) {
            output[i] = emptyMap.get(generateKey(i));

        }
        Arrays.sort(should);
        Arrays.sort(output);
        assertArrayEquals(should, output);
    }

    @Test
    @Parameters({
            "Value of:1, true",
            "Value of:50, true",
            "Value of:99, true",
            "Value of:100, false"
    })
    public void shouldCorrectlyCheckIfContainsKey(String key, boolean should) {
        assertEquals(should, initializedMap.containsKey(key));
    }

    @Test
    @Parameters({
            "Equals: 1, true",
            "Equals: 50, true",
            "Equals: 99, true",
            "Equals: 100, false"
    })
    public void shouldCorrectlyCheckIfContainsValue(String value, boolean should) {
        assertEquals(should, initializedMap.containsValue(value));
    }

    @Test
    public void shouldRemoveKeys() {
        String output[] = new String[testObjCount];
        String should[] = new String[testObjCount];
        for (int i = 0; i < testObjCount; i++) {
            initializedMap.remove(generateKey(i));
        }
        for (int i = 0; i < testObjCount; i++) {
            should[i] = null;
            output[i] = initializedMap.get(generateKey(i));
        }
        assertArrayEquals(should, output);
    }

    @Test
    public void shouldGetCorrectSize() {
        initializedMap.remove(generateKey(44));
        initializedMap.remove(generateKey(21));
        assertEquals(testObjCount - 2, initializedMap.size());
    }

    @Test
    public void shouldCorrectlyCheckIfEmpty() {
        for (int i = 0; i < testObjCount; i++) {
            initializedMap.remove(generateKey(i));
        }
        assertEquals(true, initializedMap.isEmpty());
    }

    @Test
    public void shouldReturnCorrectSizeByAssociatedKeySet() {
        assertEquals(testObjCount, keySet.size());
    }

    @Test
    public void shouldClearMapByAssociatedKeySet() {
        keySet.clear();
        assertEquals(0, keySet.size());
    }

    @Test
    public void shouldIterateOverKeysByAssociatedKeySet() {
        String output[] = new String[testObjCount];
        String should[] = new String[testObjCount];
        Iterator iterator = keySet.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            output[i] = (String) iterator.next();
            should[i] = generateKey(i);
            i++;
        }
        Arrays.sort(output);
        Arrays.sort(should);
        assertArrayEquals(should, output);
    }

    @Test
    public void shouldIterateOverValuesByAssociatedCollection() {
        String output[] = new String[testObjCount];
        String should[] = new String[testObjCount];
        Iterator iterator = values.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            output[i] = (String) iterator.next();
            should[i] = generateValue(i);
            i++;
        }
        Arrays.sort(output);
        Arrays.sort(should);
        assertArrayEquals(should, output);
    }

    @Test
    public void shouldIterateOverEntriesByAssociatedSetOfEntries() {
        String output[] = new String[testObjCount];
        String should[] = new String[testObjCount];

        Iterator iterator = setEntry.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry;// = new AbstractMap.SimpleEntry<String, String>();
            entry = (Map.Entry<String, String>) iterator.next();
            output[i] = entry.getKey() + entry.getValue();
            should[i] = generateKey(i) + generateValue(i);
            i++;
        }
        Arrays.sort(output);
        Arrays.sort(should);
        assertArrayEquals(should, output);
    }
}





