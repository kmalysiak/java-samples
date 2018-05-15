package pl.coderstrust.numbers_from_file.stream;

import pl.coderstrust.numbers_from_file.GeneralFileProcessor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileProcessorStream implements GeneralFileProcessor {

    public List<Integer[]> getArrayFromFile(String fnameInput) {
        List<Integer[]> arrayFromFile = new ArrayList<>();
        try (Stream<String> rawFileContent = Files.lines(Paths.get(fnameInput))) {
            arrayFromFile = rawFileContent
                    .map(line -> line.split("\n+"))
                    .flatMap(Arrays::stream)
                    .map(line -> line.split(" +"))
                    .filter(line -> countNumbersToSum(line) > 0)
                    .map((line) -> {
                        int numbersCount = countNumbersToSum(line);
                        Integer[] numbersToSum = new Integer[numbersCount];
                        int j = 0;
                        for (int i = 0; i < line.length; i++) {
                            if (isInteger(line[i])) {
                                numbersToSum[j] = Integer.parseInt(line[i]);
                                j++;
                            }
                        }
                        return numbersToSum;
                    })
                    .collect(Collectors.toList());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayFromFile;
    }

    private int countNumbersToSum(String[] splitInput) {
        int counter = 0;
        for (int i = 0; i < splitInput.length; i++)
            if (isInteger(splitInput[i])) {
                counter++;
            }
        return counter;
    }

    private static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        return true;
    }

    public boolean saveArrayToFile(String fNameOutput, List<String> numbersAndSums) {
        try (BufferedWriter locFile = new BufferedWriter(new FileWriter(fNameOutput))) {
            for (String item : numbersAndSums) {
                locFile.write(item + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
