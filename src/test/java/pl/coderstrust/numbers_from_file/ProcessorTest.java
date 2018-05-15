package pl.coderstrust.numbers_from_file;

import junitparams.JUnitParamsRunner;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.IOException;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public abstract class ProcessorTest {

    private static String pathToTestInput;
    private static String pathToTestOutput;

    public abstract GeneralProcessor getProcessor();

    @BeforeClass
    public static void processorTest() {

        pathToTestInput = "src\\test\\resources\\pl.coderstrust\\numbers_from_file\\testInput\\";
        pathToTestOutput = "src\\test\\resources\\pl.coderstrust\\numbers_from_file\\testOutput\\";
    }

    @Test
    public void shouldReturnFalseWhenNoInputFile() {
        String fNameInput = pathToTestInput + "nonexistentInput.txt";
        String fNameOutput = pathToTestOutput + "nonexistentOutput.txt";
        boolean status = getProcessor().process(fNameInput, fNameOutput);
        assertEquals(status, false);
    }

    @Test
    public void shouldReturnFalseWhenNoIntegerInInputFile() {
        String fNameInput = pathToTestInput + "noIntegerInput.txt";
        String fNameOutput = pathToTestOutput + "nonexistentOutput.txt";
        boolean status = getProcessor().process(fNameInput, fNameOutput);
        assertEquals(status, false);
    }

    @Test
    public void shouldNotCreateOutputFileWhenNoInputFile() {
        String fNameInput = pathToTestInput + "nonexistentInput.txt";
        String fNameOutput = pathToTestOutput + "nonexistentOutput.txt";
        getProcessor().process(fNameInput, fNameOutput);
        assertFalse(new File(fNameOutput).exists());

    }

    @Test
    public void shouldNotCreateOutputFileWhenWhenNoIntegerInInputFile() {
        String fNameInput = pathToTestInput + "noIntegerInput.txt";
        String fNameOutput = pathToTestOutput + "nonexistentOutput.txt";
        getProcessor().process(fNameInput, fNameOutput);
        assertFalse(new File(fNameOutput).exists());

    }

    @Test
    public void shouldReturnCorrectResultWithSampleData() {
        String fNameInput = pathToTestInput + "1000Input.txt";
        String fNameOutput = pathToTestOutput + "1000_output.txt";
        String fNameCorrectResult = pathToTestInput + "1000Correct.txt";
        getProcessor().process(fNameInput, fNameOutput);
        try {
            assertTrue(FileUtils.contentEquals(new File(fNameOutput), new File(fNameCorrectResult)));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            assertFalse("Files for processor not found!", true);
        }
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
