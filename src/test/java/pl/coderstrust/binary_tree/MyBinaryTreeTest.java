package pl.coderstrust.binary_tree;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertArrayEquals;

public class MyBinaryTreeTest {
    private static  MyBinaryTree bigTree = new MyBinaryTree();
    private static  MyBinaryTree bigTreeToCheckDelete = new MyBinaryTree();

    private static int elementsCount = 10876;
    private static int elementsToDelete = 144;

    @BeforeClass
    public static void initializeTree() {
        int inputBigTree[];

        List<Integer> tempInputBigTree = Arrays.stream(IntStream.range(0, elementsCount).toArray()).boxed().collect(Collectors.toList());
        Collections.shuffle(tempInputBigTree);
        inputBigTree = tempInputBigTree.stream().mapToInt(i->i).toArray();

        for (int i = 0; i < inputBigTree.length; i++) {
            bigTree.add(inputBigTree[i]);
            bigTreeToCheckDelete.add(inputBigTree[i]);
        }

        for (int i = 0; i < elementsToDelete; i++) {
            bigTreeToCheckDelete.delete(i);
        }
    }

    @Test
    public void shouldReturnSortedElementsWithInOrder() {
        int[] output = bigTree.traverseInOrder();
        assertArrayEquals(IntStream.range(0, elementsCount).toArray(), output);
    }

    @Test
    public void shouldFindAllElementsAdded() {
        boolean should[] = new boolean[elementsCount];
        boolean output[] = new boolean[elementsCount];
        for (int i = 0; i < elementsCount; i++) {
            should[i] = true;
            output[i] = bigTree.find(i);
        }
        assertArrayEquals(should, output);
    }

    @Test
    public void shouldReturnAllTreeElementsWithPreOrder() {
        int[] preOrderOutput = bigTree.traversePreOrder();
        Arrays.sort(preOrderOutput);
        assertArrayEquals(IntStream.range(0, elementsCount).toArray(), preOrderOutput);
    }

    @Test
    public void shouldReturnAllTreeElementsWithPostOrder() {
        int[] postOrderOutput = bigTree.traversePostOrder();
        Arrays.sort(postOrderOutput);
        assertArrayEquals(IntStream.range(0, elementsCount).toArray(), postOrderOutput);
    }

    @Test
    public void shouldReturnAllTreeElementsWithInOrder() {
        int[] inOrderOutput = bigTree.traversePreOrder();
        Arrays.sort(inOrderOutput);
        assertArrayEquals(IntStream.range(0, elementsCount).toArray(), inOrderOutput);
    }
    @Test
    public void shouldReturnSortedElementsWithInOrderAfterSomeElementsRemoval(){
        int[] should = IntStream.range(elementsToDelete, elementsCount).toArray();
        int[] output = bigTreeToCheckDelete.traverseInOrder();
        assertArrayEquals(should,output);
    }

    @Test
    public void shouldReturnAllElementsWithPostOrderAfterSomeElementsRemoval(){
        int[] should = IntStream.range(elementsToDelete, elementsCount).toArray();
        int[] output = bigTreeToCheckDelete.traversePostOrder();
        Arrays.sort(output);
        assertArrayEquals(should,output);
    }

    @Test
    public void shouldReturnAllElementsWithPreOrderAfterSomeElementsRemoval(){
        int[] should = IntStream.range(elementsToDelete, elementsCount).toArray();
        int[] output = bigTreeToCheckDelete.traversePreOrder();
        Arrays.sort(output);
        assertArrayEquals(should,output);
    }

}