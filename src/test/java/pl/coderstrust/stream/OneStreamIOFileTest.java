package pl.coderstrust.stream;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class OneStreamIOFileTest {

  private static final String PATH_FILE_RESULT =
      "src/test/java/pl/coderstrust/stream/sampleFiles/result/";
  private static final String PATH_FILE_INPUT =
      "src/test/java/pl/coderstrust/stream/sampleFiles/input/";

  @Rule
  public TemporaryFolder temporaryFolder = new TemporaryFolder();

  @Test
  @Parameters({
      PATH_FILE_INPUT + "1000PrimeNumbers.txt,"
          + PATH_FILE_RESULT + "1000PrimeNumbersResult.txt",
      PATH_FILE_INPUT + "numbersAndLetters(short).txt,"
          + PATH_FILE_RESULT + "numbersAndLetters(short)Result.txt",
      PATH_FILE_INPUT + "10_000PrimesNumbers.txt,"
          + PATH_FILE_RESULT + "10_000PrimesNumbersResult.txt",
      PATH_FILE_INPUT + "numbersAndLetters.txt,"
          + PATH_FILE_RESULT + "numbersAndLettersResult.txt",
      PATH_FILE_INPUT + "onlyLetters.txt,"
          + PATH_FILE_RESULT + "exceptedResultStreamEmpty.txt",
      PATH_FILE_INPUT + "emptyFile.txt, "
          + PATH_FILE_RESULT + "exceptedResultStreamEmpty.txt"})

  public void shouldBeEqualAsExpectedFile(String inputFilePath, String exceptedFilePath)
      throws IOException {
    File outputFile = temporaryFolder.newFile("temporaryFile.txt");
    new OneStreamIOFile()
        .readFileAndWriteProcessedLinesToOutputFile(inputFilePath, outputFile.getAbsolutePath());

    List<String> list = new ArrayList<>();
    List<String> expectedList = new ArrayList<>();

    try (Stream<String> stringStream = Files
        .lines(Paths.get(outputFile.getAbsolutePath()))) {
      stringStream.forEach(list::add);
    }
    try (Stream<String> stringStream = Files.lines(Paths.get(exceptedFilePath))) {
      stringStream.forEach(expectedList::add);
    }
    for (int i = 0; i < expectedList.size(); i++) {
      assertEquals(list.get(i), expectedList.get(i));
    }
  }
}