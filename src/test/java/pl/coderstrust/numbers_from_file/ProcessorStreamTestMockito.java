package pl.coderstrust.numbers_from_file;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pl.coderstrust.numbers_from_file.stream.FileProcessorStream;
import pl.coderstrust.numbers_from_file.stream.ProcessorStream;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProcessorStreamTestMockito {

    private static String pathToTestInput;
    private static String pathToTestOutput;


    @Mock
    private FileProcessorStream fileProcessor;

    @InjectMocks
    private ProcessorStream processor;

    @BeforeClass
    public static void processorTest() {
        pathToTestInput = "src\\test\\resources\\pl.coderstrust\\numbers_from_file\\testInput\\";
        pathToTestOutput = "src\\test\\resources\\pl.coderstrust\\numbers_from_file\\testOutput\\";
    }

    @Test
    public void shouldRunWithMockito() {
        List<Integer[]> testInput = new ArrayList<>();
        testInput.add(new Integer[]{1, 2});
        testInput.add(new Integer[]{2, 3});
        when(fileProcessor.getArrayFromFile("test1")).thenReturn(testInput);
        when(fileProcessor.saveArrayToFile(anyString(), anyList())).thenCallRealMethod();
        String fNameOutput = pathToTestOutput + "correctArrayInputForMockTest.txt";
        String fNameCorrectResult = pathToTestInput + "correctArrayInputForMockTest.txt";
        processor.process("test1", fNameOutput);
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
