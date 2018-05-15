package pl.coderstrust.my_array_list;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public abstract class ListTestBaseGeneric<E> {
    public abstract List getList();

    public abstract E getTestObject(int index);

    List<E> testList;

    @Before
    public void initializeStdTestInput() {
        testList = getList();
        testList.addAll(Arrays.asList(getTestObject(2), getTestObject(3), getTestObject(2), getTestObject(4)));
    }

    @Test
    public void shouldInsertElementToEmptyListPos0() {
        List<E> test = getList();
        List<E> output = new ArrayList<>();
        output.add(getTestObject(6));
        test.add(0, getTestObject(6));
        assertArrayEquals(output.toArray(), test.toArray());
    }

    @Test
    public void shouldInsertElementToNonEmptyListPos0() {
        List<E> test = getList();
        test.add(0, getTestObject(2));
        test.add(0, getTestObject(6));
        List<E> output = new ArrayList<>();
        output.add(getTestObject(6));
        output.add(getTestObject(2));

        assertArrayEquals(output.toArray(), test.toArray());
    }

    @Test
    public void shouldInsertElementToNonEmptyListPosLast() {
        List<E> test = getList();
        test.add(0, getTestObject(2));
        test.add(1, getTestObject(6));
        List<E> output = new ArrayList<>();
        output.add(getTestObject(2));
        output.add(getTestObject(6));
        assertArrayEquals(output.toArray(), test.toArray());
    }

    @Test
    public void shouldInsertElementToNonEmptyListPosMiddle() {
        List<E> test = getList();
        test.add(0, getTestObject(2));
        test.add(0, getTestObject(6));
        test.add(1, getTestObject(5));
        List<E> output = new ArrayList<>();
        output.add(getTestObject(6));
        output.add(getTestObject(5));
        output.add(getTestObject(2));
        assertArrayEquals(output.toArray(), test.toArray());
    }

    @Test
    public void shouldInsert100Elements() {
        List<E> test = getList();
        List<E> result = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            test.add(0, getTestObject((i)));
            result.add(0, getTestObject((i)));
        }
        assertArrayEquals(result.toArray(), test.toArray());
    }

    @Test
    public void shouldInsertAndRemoveLargeQuantityData() {
        List<E> test = getList();
        List<E> result = new ArrayList<>();

        for (int i = 0; i < 1000000; i++) {
            test.add(getTestObject(i));
            result.add(getTestObject(i));
        }
        for (int i = 0; i < 20000; i++) {
            test.remove(getTestObject(i));
            result.remove(getTestObject(i));
        }
        assertArrayEquals(result.toArray(), test.toArray());
    }

    @Test
    public void shouldRemoveFirstObjectOccurrence() {
        initializeStdTestInput();
        testList.remove(getTestObject(2));
        testList.remove(getTestObject(4));
        List<E> output = new ArrayList<>();
        output.addAll(Arrays.asList(getTestObject(3), getTestObject(2)));
        assertArrayEquals(output.toArray(), testList.toArray());
    }

    @Test
    public void shouldRemoveElementsSpecifiedInCollection() {
        initializeStdTestInput();
        testList.removeAll(Arrays.asList(getTestObject(2), getTestObject(4), getTestObject(5)));
        List<E> output = new ArrayList<>();
        output.add(getTestObject(3));
        assertArrayEquals(output.toArray(), testList.toArray());
    }

    @Test
    public void shouldRemoveElementsSpecifiedInCollectionWhenAllElementsNeedRemoval() {
        initializeStdTestInput();
        testList.removeAll(Arrays.asList(getTestObject(2), getTestObject(3), getTestObject(2), getTestObject(4)));
        Long output[] = new Long[]{};
        assertEquals(output.length, testList.toArray().length);
    }

    @Test
    public void shouldRetainOnlyElementsSpecifiedInCollection() {
        initializeStdTestInput();
        List<E> toRetain = new ArrayList<>();
        toRetain.addAll(Arrays.asList(getTestObject(4), getTestObject(5)));
        testList.retainAll(toRetain);
        List<E> output = new ArrayList<>();
        output.add(getTestObject(4));
        assertArrayEquals(output.toArray(), testList.toArray());
    }

    @Test
    public void shouldReturnEmptyArrayWhenCleared() {
        initializeStdTestInput();
        testList.clear();
        Long output[] = new Long[]{};
        assertEquals(output.length, testList.toArray().length);
    }

    @Test
    public void shouldReturnCorrectSize() {
        initializeStdTestInput();
        assertEquals(4, testList.size());
    }

    @Test
    public void shouldReturnZeroForEmptyArray() {
        List<E> test = getList();
        assertEquals(0, test.size());
    }

    @Test
    public void shouldReturnTrueWhenListEmpty() {
        List<E> test = getList();
        assertEquals(true, test.isEmpty());
    }

    @Test
    public void shouldReturnFalseWhenListNotEmpty() {
        initializeStdTestInput();
        assertEquals(false, testList.isEmpty());
    }

    @Test
    public void shouldReturnTrueWhenListContainsObject() {
        initializeStdTestInput();
        assertEquals(true, testList.contains(getTestObject(2)));
    }

    @Test
    public void shouldReturnFalseWhenListDoesNotContainsObject() {
        initializeStdTestInput();
        assertEquals(false, testList.contains(getTestObject(5)));
    }

    @Test
    public void shouldReturnCorrectArray() {
        initializeStdTestInput();
        List<E> output = new ArrayList<>();
        output.addAll(Arrays.asList(getTestObject(2), getTestObject(3), getTestObject(2), getTestObject(4)));
        assertArrayEquals(output.toArray(), testList.toArray());
    }

    @Test
    public void shouldAllocateNewArrayAndReturnIt() {
        initializeStdTestInput();
        E parameter[] = (E[]) new Object[]{getTestObject(1)};
        E result[] = testList.toArray(parameter);
        assertArrayEquals(result, testList.toArray());
    }

    @Test
    public void shouldReturnArrayIntoParameter() {
        initializeStdTestInput();
        E parameter[] = (E[]) new Object[]{getTestObject(1), getTestObject(1), getTestObject(1), getTestObject(1)};
        testList.toArray(parameter);
        assertArrayEquals(parameter, testList.toArray());
    }


    @Test
    public void shouldReturnSubListFromRangeSpecifiedInclusive() {
        initializeStdTestInput();
        List<E> sublist = testList.subList(1, 3);
        List<E> output = new ArrayList<>();
        output.addAll(Arrays.asList(getTestObject(3), getTestObject(2)));
        assertArrayEquals(output.toArray(), sublist.toArray());
    }

    @Test
    public void shouldReturnTrueWhenAllCollectionElementsFound() {
        initializeStdTestInput();
        List<E> toFind = new ArrayList<>();
        toFind.add(getTestObject(2));
        toFind.add(getTestObject(3));
        assertEquals(true, testList.containsAll(toFind));
    }

    @Test
    public void shouldReturnTrueWhenListsHaveTheSameContent() {
        initializeStdTestInput();

        assertTrue(testList.equals(testList));
    }

    @Test
    public void shouldReturnCorrectListElement() {
        initializeStdTestInput();
        assertEquals(getTestObject(4), testList.get(3));
    }

    @Test
    public void shouldRemoveElementAtPostionIndex() {
        initializeStdTestInput();
        testList.remove(0);
        testList.remove(1);
        List<E> output = new ArrayList<>();
        output.addAll(Arrays.asList(getTestObject(3), getTestObject(4)));
        assertArrayEquals(output.toArray(), testList.toArray());
    }

    @Test
    public void shouldReturnCorrectIndexWhenListContainsObject() {
        initializeStdTestInput();
        assertEquals(3, testList.indexOf(getTestObject(4)));
    }

    @Test
    public void shouldReturnNullWhenListDoesNotContainsObject() {
        initializeStdTestInput();
        assertEquals(-1, testList.indexOf(getTestObject(5)));
    }

    @Test
    public void shouldReturnLastIndexElement() {
        initializeStdTestInput();
        assertEquals(2, testList.lastIndexOf(getTestObject(2)));
    }

    @Test
    public void shouldReturnCorrectIterator() {
        initializeStdTestInput();
        List<E> output = new ArrayList<>();
        Iterator<E> itr = testList.iterator();
        while (itr.hasNext()) {
            output.add(itr.next());
        }
        assertArrayEquals(output.toArray(), testList.toArray());
    }

    @Test
    public void shouldReturnCorrectListIterator() {
        initializeStdTestInput();
        List<E> output = new ArrayList<>();
        ListIterator<E> itr = testList.listIterator();
        while (itr.hasNext()) {
            output.add(itr.next());
        }
        assertArrayEquals(output.toArray(), testList.toArray());
    }

    @Test
    public void shouldReturnCorrectListIteratorStartingAtGivenIndex() {
        initializeStdTestInput();
        List<E> output = new ArrayList<>();
        ListIterator<E> lItr = testList.listIterator(1);
        while (lItr.hasNext()) {
            output.add(lItr.next());
        }
        assertArrayEquals(output.toArray(), Arrays.copyOfRange(testList.toArray(), 1, 4));
    }

    @Test
    public void shouldListIteratorCheckIfPreviousElementExist() {
        initializeStdTestInput();
        ListIterator<E> lItr = testList.listIterator(0);
        assertFalse(lItr.hasPrevious());
    }

    @Test
    public void shouldListIteratorReturnPreviousElement() {
        initializeStdTestInput();
        ListIterator<E> lItr = testList.listIterator(2);
        assertEquals(getTestObject(3), lItr.previous());
    }

    @Test
    public void shouldListIteratorReturnNextIndex() {
        initializeStdTestInput();
        ListIterator<E> lItr = testList.listIterator(2);
        assertEquals(2, lItr.nextIndex());
    }

    @Test
    public void shouldListIteratorReturnPreviousIndex() {
        initializeStdTestInput();
        ListIterator<E> lItr = testList.listIterator(2);
        assertEquals(1, lItr.previousIndex());
    }

    @Test
    public void shouldListIteratorRemoveAtIndex() {
        initializeStdTestInput();
        ListIterator<E> lItr = testList.listIterator(2);
        lItr.next();
        lItr.remove();
        List<E> output = new ArrayList<>();
        output.addAll(Arrays.asList(getTestObject(2), getTestObject(3), getTestObject(4)));

        assertArrayEquals(output.toArray(), testList.toArray());
    }

    @Test
    public void shouldListIteratorSetAtIndex() {
        initializeStdTestInput();
        ListIterator<E> lItr = testList.listIterator(2);
        lItr.next();
        lItr.set(getTestObject(5));
        List<E> output = new ArrayList<>();
        output.addAll(Arrays.asList(getTestObject(2), getTestObject(3), getTestObject(5), getTestObject(4)));
        assertArrayEquals(output.toArray(), testList.toArray());
    }

    @Test
    public void shouldListIteratorAddAtIndex() {
        initializeStdTestInput();
        ListIterator<E> lItr = testList.listIterator(2);
        lItr.add(getTestObject(5));
        List<E> output = new ArrayList<>();
        output.addAll(Arrays.asList(getTestObject(2), getTestObject(3), getTestObject(5), getTestObject(2), getTestObject(4)));
        assertArrayEquals(output.toArray(), testList.toArray());
    }
}

