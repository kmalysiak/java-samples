package pl.coderstrust.christmas_tree;

import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ChristmasTreeTest {

    private final ByteArrayOutputStream stdOutputContent = new ByteArrayOutputStream();
    private ChristmasTree tree;
    private String newLine = System.getProperty("line.separator");

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(stdOutputContent));
        tree = new ChristmasTree();
    }

    @Test
    public void shouldPrintNothingForSize0() {
        tree.printChristmasTree(0);
        assertEquals("", stdOutputContent.toString());
    }

    @Test
    public void shouldPrintCorrectOutputForSize1() {
        tree.printChristmasTree(1);
        assertEquals("*" + newLine + "**" + newLine, stdOutputContent.toString());
    }

    @Test
    public void shouldPrintCorrectOutputForSize3() {
        tree.printChristmasTree(3);
        assertEquals("  *" + newLine + " ***" + newLine + "*****" + newLine + " **" + newLine, stdOutputContent.toString());
    }

    @Test
    public void shouldCorrectlyEndEachLine() {
        int treeSize = 100;
        tree.printChristmasTree(treeSize);
        String output[] = stdOutputContent.toString().split(newLine);
        boolean outputLastCharacter[] = new boolean[output.length];
        boolean shouldLastCharacter[] = new boolean[output.length];
        for (int i = 0; i < output.length; i++) {
            outputLastCharacter[i] = output[i].endsWith("*");
            shouldLastCharacter[i] = true;
        }
        assertArrayEquals(shouldLastCharacter,outputLastCharacter);
    }

    @Test
    public void shouldPrintCorrectNumberOfSpacesEachLine() {
        int treeSize = 100;
        tree.printChristmasTree(treeSize);
        String output[] = stdOutputContent.toString().split(newLine);
        int outputSpacesCount[] = new int[output.length];
        int shouldSpacesCount[] = new int[output.length];
        for (int i = 0; i < output.length; i++) {
            outputSpacesCount[i] = StringUtils.countMatches(output[i], " ");
            shouldSpacesCount[i] = treeSize - i - 1;
        }
        shouldSpacesCount[output.length - 1] = treeSize - 2;
        assertArrayEquals(shouldSpacesCount, outputSpacesCount);
    }

    @Test
    public void shouldPrintCorrectNumberOfStarsEachLine() {
        int treeSize = 100;
        tree.printChristmasTree(treeSize);
        String output[] = stdOutputContent.toString().split(newLine);
        int outputSpacesCount[] = new int[output.length];
        int shouldSpacesCount[] = new int[output.length];
        for (int i = 0; i < output.length; i++) {
            outputSpacesCount[i] = StringUtils.countMatches(output[i], "*");
            shouldSpacesCount[i] = (i + 1) * 2 - 1;
        }
        shouldSpacesCount[output.length - 1] = 2;
        assertArrayEquals(shouldSpacesCount, outputSpacesCount);
    }

    @After
    public void restoreStreams() {
        System.setOut(System.out);
    }
}