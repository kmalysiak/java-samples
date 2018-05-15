package pl.coderstrust.numbers_from_file.iterative;

import pl.coderstrust.numbers_from_file.GeneralProcessor;

import java.util.Collections;
import java.util.List;

public class Processor implements GeneralProcessor {
    FileProcessor fileProcessor;

    public Processor(FileProcessor fileProcessor) {
        this.fileProcessor = fileProcessor;
    }

    public boolean process(String fPathInput, String fPathOutput) {

        boolean success = false;
        final List<Integer[]> unmodArrayFromFile = Collections.unmodifiableList(fileProcessor.getArrayFromFile(fPathInput));
        if (unmodArrayFromFile.size() > 0) {
            NumbersProcessor numProc = new NumbersProcessor();

            if (fileProcessor.saveArrayToFile(fPathOutput, Collections.unmodifiableList(numProc.getNumbersAndSums(unmodArrayFromFile)))) {
                success = true;
            }
        }
        return success;
    }
}

