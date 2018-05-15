package pl.coderstrust.my_array_list;

import java.util.*;

public class MyArrayList<E> implements List<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private E[] data;
    private int size = 0;
    private static final int INFLATE_MULTIPLIER = 2;
    private static final int DEFLATE_FACTOR = 4;

    public MyArrayList() {
        data = (E[]) new Object[0];
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object toFind) {
        return indexOf(toFind) >= 0;
    }

    @Override
    public int indexOf(Object toFind) {
        if (toFind == null) {
            for (int i = 0; i < size; i++) {
                if (data[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (toFind.equals(data[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object toFind) {
        if (toFind == null) {
            for (int i = data.length - 1; i >= 0; i--) {
                if (data[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = data.length - 1; i >= 0; i--) {
                if (toFind.equals(data[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(data, size);
    }

    @Override
    public <E> E[] toArray(E[] givenArray) {
        if (givenArray.length < size) {
            return (E[]) Arrays.copyOf(data, size, givenArray.getClass());
        }
        System.arraycopy(data, 0, givenArray, 0, size);
        if (givenArray.length > size) {
            givenArray[size] = null;
        }
        return givenArray;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        if (shouldInflate()) {
            inflate();
        }
        if (size == 0) {
            data[0] = element;
        } else {
            System.arraycopy(data, index, data, index + 1, size - index);
            data[index] = element;
        }
        size++;
    }

    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("Specified index:" + index + "invalid. Should be >0 and <" + size);
    }

    private boolean shouldInflate() {
        return (data.length == size);
    }

    private void inflate() {
        int newLength = Math.max(data.length * INFLATE_MULTIPLIER, DEFAULT_CAPACITY);
        data = Arrays.copyOf(data, newLength);
    }

    private void inflate(int newLength) {
        data = Arrays.copyOf(data, newLength);
    }

    @Override
    public boolean add(E newValue) {
        add(size, newValue);
        return true; // ArrayList allows duplicates so this returns true
    }


    @Override
    public boolean addAll(int index, Collection<? extends E> newValues) {
        rangeCheckForAdd(index);
        Object[] newValuesArray = newValues.toArray();
        int sizeNew = newValuesArray.length;
        if (sizeNew == 0) {
            return false;
        }
        int sizeOriginal = size;
        if (sizeNew > data.length - sizeOriginal) {
            inflate(sizeOriginal + sizeNew);
        }

        int numMoved = sizeOriginal - index;
        if (numMoved > 0) {
            System.arraycopy(data, index, data, index + sizeNew, numMoved);
        }
        System.arraycopy(newValuesArray, 0, data, index, sizeNew);
        size = sizeOriginal + sizeNew;
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> newValue) {
        return addAll(size, newValue);
    }

    @Override
    public E remove(int index) {
        Objects.checkIndex(index, size);
        E oldValue = data[index];
        int numMoved = data.length - index - 1;
        if (numMoved > 0) {
            System.arraycopy(data, index + 1, data, index, numMoved);
        }
        data[(data.length) - 1] = null;
        size--;
        if (shouldDeflate()) {
            deflate();
        }
        return oldValue;
    }

    private boolean shouldDeflate() {
        return (size <= data.length / DEFLATE_FACTOR);
    }

    private void deflate() {
        data = Arrays.copyOf(data, size);
    }

    @Override
    public boolean remove(Object toRemove) {
        if (toRemove == null) {
            for (int index = 0; index < data.length; index++) {
                if (data[index] == null) {
                    remove(index);
                    return true;
                }
            }
        } else {
            for (int index = 0; index < data.length; index++) {
                if (toRemove.equals(data[index])) {
                    remove(index);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> toRemove) {
        Iterator iterator = toRemove.iterator();
        while (iterator.hasNext()) {
            removeAll(iterator.next());
        }
        return true;
    }

    private void removeAll(Object toRemove) {
        int firstIndex;
        do {
            firstIndex = indexOf(toRemove);
            if (firstIndex != -1) {
                remove(firstIndex);
            }
        }
        while (firstIndex != -1);
    }


    @Override
    public boolean retainAll(Collection<?> toRetain) {
        Object rawDataTemp[] = Arrays.copyOf(data, data.length);
        boolean shouldRetain;
        int rawDataCountTemp = size;
        for (int i = 0; i < rawDataCountTemp; i++) {
            shouldRetain = false;
            Iterator iterator = toRetain.iterator();
            while (iterator.hasNext()) {
                if (iterator.next().equals(rawDataTemp[i])) {
                    shouldRetain = true;
                    break;
                }
            }
            if (!shouldRetain) {
                remove(rawDataTemp[i]);
            }
        }
        return true;
    }

    @Override
    public void clear() {
        for (int i = size - 1; i >= 0; i--) {
            remove(i);
        }
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, data.length);
        return data[index];
    }

    @Override
    public E set(int index, E element) {
        Objects.checkIndex(index, data.length);
        E oldValue = data[index];
        data[index] = element;
        return oldValue;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return Arrays.asList((E[]) Arrays.copyOfRange(data, fromIndex, toIndex));
    }

    @Override
    public boolean containsAll(Collection<?> shouldContain) {
        for (Object e : shouldContain) {
            if (!contains(e)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<E> {
        int currentIndex = 0;
        int lastReturned = -1;

        public boolean hasNext() {
            return currentIndex != size;
        }

        public E next() {
            currentIndex++;
            lastReturned = currentIndex - 1;
            return data[currentIndex - 1];
        }

        @Override
        public void remove() {
            if (lastReturned < 0)
                throw new IllegalStateException("Cannot remove without previous next");
            MyArrayList.this.remove(lastReturned);
            currentIndex = lastReturned;
            lastReturned = -1;
        }
    }

    @Override
    public ListIterator<E> listIterator() {
        return new MyListIterator(0);
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return new MyListIterator(index);
    }

    private class MyListIterator extends MyIterator implements ListIterator<E> {
        MyListIterator(int index) {
            super();
            currentIndex = index;
        }

        @Override
        public boolean hasPrevious() {
            return currentIndex != 0;
        }

        @Override
        public E previous() {
            int i = currentIndex - 1;
            if (i < 0) {
                throw new NoSuchElementException("Invalid index:" + i + ". Should be >=0");
            }
            currentIndex = i;
            lastReturned = i;
            return data[i];
        }

        @Override
        public int nextIndex() {
            return currentIndex;
        }

        @Override
        public int previousIndex() {
            return currentIndex - 1;
        }

        @Override
        public void set(E value) {
            if (lastReturned < 0) {
                throw new IllegalStateException("Cannot set without preceding  next or previous");
            }
            MyArrayList.this.set(lastReturned, value);
        }

        @Override
        public void add(E value) {
            MyArrayList.this.add(currentIndex, value);

        }
    }
}