package pl.coderstrust.numbers_from_file.iterative;

import pl.coderstrust.numbers_from_file.GeneralFileProcessor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileProcessor implements GeneralFileProcessor {

    public List<Integer[]> getArrayFromFile(String fnameInput) {
        List<Integer[]> arrayFromFile = new ArrayList<>();
        try (BufferedReader dirFile = new BufferedReader(new FileReader(fnameInput))) {
            String rawLineInput;
            while ((rawLineInput = dirFile.readLine()) != null) {
                String[] splitInput = rawLineInput.split(" ");
                Integer[] numbersToSum = new Integer[countNumbersToSum(splitInput)];
                if (numbersToSum.length > 0) {
                    int j = 0;
                    for (int i = 0; i < splitInput.length; i++) {
                        if (isInteger(splitInput[i])) {
                            numbersToSum[j] = Integer.parseInt(splitInput[i]);
                            j++;
                        }
                    }
                    arrayFromFile.add(numbersToSum);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
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