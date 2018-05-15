package pl.coderstrust.my_linked_list;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class MyLinkedListTest {

    MyLinkedList listForTest;

    @Before
    public void resetListForTest() {
        listForTest = new MyLinkedList();
        listForTest.add(Integer.valueOf(1));
        listForTest.add(Integer.valueOf(10));
        listForTest.add(Integer.valueOf(100));

    }

    @Test
    public void shouldReturnTrueWhenListContainsElementAtHead() {
        MyLinkedList test = new MyLinkedList();
        test.add(Integer.valueOf(1));
        assertTrue(test.contains(Integer.valueOf(1)));
    }

    @Test
    public void shouldReturnTrueWhenListContainsElementNotAtHeadOrTail() {
        resetListForTest();
        assertTrue(listForTest.contains(Integer.valueOf(10)));
    }

    @Test
    public void shouldReturnTrueWhenListContainsElementInMiddleOfList() {
        resetListForTest();
        assertTrue(listForTest.contains(Integer.valueOf(1)));
    }

    @Test
    public void shouldReturnFalseWhenListContainsNoElements() {
        MyLinkedList test = new MyLinkedList();
        test.add(Integer.valueOf(1));
        assertFalse(test.contains(Integer.valueOf(5)));
    }

    @Test
    public void shouldAddElements() {
        MyLinkedList test = new MyLinkedList();
        test.add(Integer.valueOf(44));
        assertTrue(test.contains(Integer.valueOf(44)));
    }

    @Test
    public void shouldRemoveElementFromHead() {
        resetListForTest();
        listForTest.remove(100);
        assertFalse(listForTest.contains(Integer.valueOf(100)));
    }

    @Test
    public void shouldRemoveElementFromTail() {
        resetListForTest();
        listForTest.remove(1);
        assertFalse(listForTest.contains(Integer.valueOf(1)));
    }

    @Test
    public void shouldRemoveElementFromMiddleOfList() {
        resetListForTest();
        listForTest.remove(10);
        assertFalse(listForTest.contains(Integer.valueOf(10)));
    }

    @Test
    public void shouldIterateOverList() {
        resetListForTest();
        Iterator iter = listForTest.iterator();
        List<Object> output = new ArrayList();
        while (iter.hasNext()) {
            output.add(iter.next());
        }
        assertArrayEquals(new Integer[]{1, 10, 100}, output.toArray());
    }

    @Test
    public void shouldIteratorRemovElementFromList() {
        resetListForTest();
        Iterator iter = listForTest.iterator();
        List<Object> output = new ArrayList();
        iter.next();
        iter.remove();
        while (iter.hasNext()) {
            output.add(iter.next());
        }
        assertArrayEquals(new Integer[]{10, 100}, output.toArray());
    }
}