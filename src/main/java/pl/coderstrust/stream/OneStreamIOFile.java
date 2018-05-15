package pl.coderstrust.stream;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class OneStreamIOFile {

  public void readFileAndWriteProcessedLinesToOutputFile(String fileReadPath,
      String outputFileName) {
    try (Stream<String> streamReader = Files.lines(Paths.get(fileReadPath));
        PrintWriter printWriter = new PrintWriter(outputFileName)) {

      streamReader
          .filter(line -> line.matches("[\\d\\s]+"))
          .map(line -> Arrays.stream(line.trim().split("[\\s]+"))
              .reduce((a, b) -> a + "+" + b).get() + "="
              + Arrays.stream(line.trim().split("[\\s]+"))
              .mapToInt(Integer::valueOf).sum())
          .forEachOrdered(printWriter::println);

    } catch (IOException e) {
      System.out.println("File not found");
      e.printStackTrace();
    }
  }
}