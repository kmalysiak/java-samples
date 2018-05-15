package pl.coderstrust.numbers_from_file;

import java.util.List;

public interface GeneralFileProcessor {
    List<Integer[]> getArrayFromFile(String fnameInput);

    boolean saveArrayToFile(String fNameOutput, List<String> numbersAndSums);
}
