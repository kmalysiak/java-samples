
package pl.coderstrust.hash_map;

import java.util.*;

public class MyHashMap<K, V> implements Map<K, V> {

    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private int size = 0;
    private int thresholdSize = 0;
    private int occupiedBuckets = 0;
    private Set<K> keySet;
    private Collection<V> values;
    private Set<Map.Entry<K, V>> entrySet;

    private class Node<K, V> implements Map.Entry<K, V> {
        K key;
        V value;
        Node next;

        Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        public final String toString() {
            return key + "=" + value;
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }
    }

    Node<K, V>[] table;

    public MyHashMap() {
        initializeNewTable();
    }

    private void initializeNewTable() {
        if (size == 0) {
            size = DEFAULT_INITIAL_CAPACITY;
        } else {
            size = 2 * size;
        }
        thresholdSize = (int) (size * DEFAULT_LOAD_FACTOR);
        table = new Node[size];

        for (int i = 0; i < size; i++) {
            table[i] = null;
        }
    }

    private void resize() {
        Node<K, V>[] oldTable = table;
        initializeNewTable();
        occupiedBuckets = 0;
        for (Node<K, V> e : oldTable) {
            for (; e != null; e = e.next) {
                if (e != null) {
                    put(e.key, e.value);
                }
            }
        }
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % size;
    }

    @Override
    public V put(K newKey, V data) {
        if (newKey == null) //does not allow null
            return null;
        if (occupiedBuckets + 1 >= thresholdSize) {
            resize();
        }
        int hash = hash(newKey);
        Node<K, V> newNode = new Node<>(newKey, data, null);

        if (table[hash] == null) {
            table[hash] = newNode;
            occupiedBuckets++;
            return data;
        } else {
            Node<K, V> current = table[hash];
            boolean stopSearch = false;
            while (!stopSearch) {
                if (current.key.equals(newKey)) {
                    current.value = data;
                    stopSearch = true;
                } else {
                    if (current.next == null) {
                        current.next = newNode;
                        stopSearch = true;

                    } else {
                        current = current.next;
                    }
                }
            }
            occupiedBuckets++;
            return data;
        }
    }

    @Override
    public V get(Object key) {
        int hash = hash((K) key);

        if (table[hash] == null) {
            return null;
        } else {
            Node<K, V> node = table[hash];
            boolean stopSearch = false;
            while (!stopSearch) {
                if (node.key.equals(key)) {
                    stopSearch = true;
                    return node.value;
                } else {
                    if (node.next != null) {
                        node = node.next;
                    } else {
                        stopSearch = true;
                    }
                }
            }
            return null;
        }
    }

    @Override
    public boolean containsKey(Object key) {
        if (table[hash((K) key)] != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean containsValue(Object value) {
        if (table != null && size > 0) {
            for (Node<K, V> node : table) {
                for (; node != null; node = node.next) {
                    if (node.value.equals(value))
                        return true;
                }
            }
        }
        return false;
    }
    
    @Override
    public V remove(Object key) {
        int hash = hash((K) key);
        if (table[hash] != null) {
            Node nodeToRemove = table[hash];
            V valueFromRemoved;
            if (nodeToRemove.key.equals(key)) {
                valueFromRemoved = (V) table[hash].value;
                table[hash] = nodeToRemove.next;
                occupiedBuckets--;
                return valueFromRemoved;
            } else {
                Node oldNode = nodeToRemove;
                nodeToRemove = nodeToRemove.next;
                for (; nodeToRemove != null; nodeToRemove = nodeToRemove.next) {
                    if (nodeToRemove.key.equals(key)) {
                        valueFromRemoved = (V) nodeToRemove.value;
                        oldNode.next = nodeToRemove.next;
                        nodeToRemove = null;
                        occupiedBuckets--;
                        return valueFromRemoved;
                    } else {
                        oldNode = nodeToRemove;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return occupiedBuckets;
    }

    @Override
    public boolean isEmpty() {
        return occupiedBuckets == 0;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> mapToPut) {
        for (Map.Entry<? extends K, ? extends V> entry : mapToPut.entrySet()) {
            if (occupiedBuckets + 1 >= thresholdSize) {
                resize();
            }
            K key = entry.getKey();
            V value = entry.getValue();
            put(key, value);
        }
    }

    @Override
    public void clear() {
        if (table != null && size > 0) {
            size = 0;
            occupiedBuckets = 0;
            for (int i = 0; i < table.length; ++i) {
                table[i] = null;
            }
        }
    }

    @Override
    public Set<K> keySet() {
        if (keySet == null) {
            keySet = new MyHashMap.KeySet();
        }
        return keySet;
    }

    class KeySet extends AbstractSet<K> {
        public int size() {
            return occupiedBuckets;
        }

        public void clear() {
            MyHashMap.this.clear();
        }

        public Iterator<K> iterator() {
            return new MyHashMap.KeyIterator();
        }

        public boolean contains(Object key) {
            return containsKey(key);
        }

        public boolean remove(Object key) {
            V output = MyHashMap.this.remove(key);
            if (output == null) {
                return false;
            } else {
                return true;
            }
        }
    }

    class KeyIterator extends MyHashMap.HashIterator
            implements Iterator<K> {
        public K next() {
            return (K) nextNode().key;
        }
    }

    abstract class HashIterator {
        MyHashMap.Node next;
        MyHashMap.Node current;
        int index;

        HashIterator() {
            current = next = null;
            index = 0;
            if (table != null && size > 0) {
                do {
                    next = table[index++];
                } while (index < table.length && (next) == null);
            }
        }

        public final boolean hasNext() {
            return next != null;
        }

        MyHashMap.Node nextNode() {
            MyHashMap.Node nextNode = next;
            if (nextNode == null) {
                throw new NoSuchElementException();
            }
            current = nextNode;
            next = current.next;
            if (next == null && (table) != null) {
                do {
                    next = table[index++];
                } while (index < table.length && next == null);
            }
            return nextNode;
        }
    }

    @Override
    public Collection<V> values() {
        if (values == null) {
            values = new MyHashMap.Values();
        }
        return values;
    }

    final class Values extends AbstractCollection<V> {
        public final int size() {
            return occupiedBuckets;
        }

        public final Iterator<V> iterator() {
            return new MyHashMap.ValueIterator();
        }
    }

    final class ValueIterator extends MyHashMap.HashIterator
            implements Iterator<V> {
        public final V next() {
            return (V) nextNode().value;
        }
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        if (entrySet == null) {
            entrySet = new MyHashMap.EntrySet();
        }
        return entrySet;
    }

    final class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        public final int size() {
            return size;
        }

        public final Iterator<Map.Entry<K, V>> iterator() {
            return new MyHashMap.EntryIterator();
        }
    }

    final class EntryIterator extends MyHashMap.HashIterator
            implements Iterator<Map.Entry<K, V>> {
        public final Map.Entry<K, V> next() {
            return (Map.Entry<K, V>) nextNode();
        }
    }

}

