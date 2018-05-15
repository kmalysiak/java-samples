package pl.coderstrust.numbers_from_file;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pl.coderstrust.numbers_from_file.iterative.FileProcessor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.*;

public abstract class FileProcessorTest {
    private static FileProcessor testFileProcessor;
    private static String pathToTestInput;
    private static String pathToTestOutput;

    public abstract GeneralFileProcessor getFileProcessor();

    @BeforeClass
    public static void processorTest() {
        // testFileProcessor = new FileProcessor();
        pathToTestInput = "src\\test\\resources\\pl.coderstrust\\numbers_from_file\\testInput\\";
        pathToTestOutput = "src\\test\\resources\\pl.coderstrust\\numbers_from_file\\testOutput\\";
    }

    @Test
    public void shouldReturnZeroSizeListWhenNoInputFile() {
        String fNameInput = pathToTestInput + "nonexistent";
        List<Integer[]> output = getFileProcessor().getArrayFromFile(fNameInput);
        assertEquals(output.size(), 0);
    }

    @Test
    public void shouldGetCorrectArrayFromFile() {
        String fNameInput = pathToTestInput + "mixedIntegerNonIntegerInput.txt";
        List<Integer[]> output = getFileProcessor().getArrayFromFile(fNameInput);
        assertArrayEquals(output.get(0), new Integer[]{1, 2, 3});

    }

    @Test
    public void shouldReturnZeroSizeWhenInputFileEmpty() {
        String fNameInput = pathToTestInput + "emptyInput.txt";
        List<Integer[]> output = getFileProcessor().getArrayFromFile(fNameInput);
        assertEquals(output.size(), 0);

    }

    @Test
    public void shouldReturnZeroSizeWhenNoIntegerInInputFile() {
        String fNameInput = pathToTestInput + "noIntegerInput.txt";
        List<Integer[]> output = getFileProcessor().getArrayFromFile(fNameInput);
        assertEquals(output.size(), 0);
    }

    @Test
    public void shouldSaveCorrectStringArrayToFile() {
        String fNameOutput = pathToTestOutput + "correctArrayOutput.txt";
        String fNameCorrect = pathToTestInput + "correctArrayInput.txt";
        List<String> input = new ArrayList<>();
        input.add("testFileProcessor array line 1");
        input.add("testFileProcessor array line 2");

        getFileProcessor().saveArrayToFile(fNameOutput, input);
        try {
            assertTrue(FileUtils.contentEquals(new File(fNameOutput), new File(fNameCorrect)));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            assertFalse("Files for testFileProcessor not found!", true);
        }

    }

    @Test
    public void shouldReturnFalseWhenNotPossibleToSaveToFile() {
        String fNameOutput = pathToTestInput + "fileBlockedOutput.txt";
        List<String> testData = new ArrayList<>();
        testData.add("Test data");
        assertFalse(getFileProcessor().saveArrayToFile(fNameOutput, testData));
    }

    @AfterClass
    public static void cleanTestOutputFolder() {
        try {
            FileUtils.cleanDirectory(new File(pathToTestOutput));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}