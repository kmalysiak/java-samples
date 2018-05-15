package pl.coderstrust.numbers_from_file.stream;

import pl.coderstrust.numbers_from_file.GeneralFileProcessor;
import pl.coderstrust.numbers_from_file.GeneralProcessor;

import java.util.Collections;
import java.util.List;

public class ProcessorStream implements GeneralProcessor {
    FileProcessorStream fileProcessorStream;

    public ProcessorStream(GeneralFileProcessor fileProcessorStream) {
        this.fileProcessorStream = (FileProcessorStream) fileProcessorStream;
    }

    public boolean process(String fPathInput, String fPathOutput) {

        boolean success = false;
        final List<Integer[]> unmodArrayFromFile = Collections.unmodifiableList(fileProcessorStream.getArrayFromFile(fPathInput));
        if (unmodArrayFromFile.size() > 0) {
            NumbersProcessorStream numProc = new NumbersProcessorStream();

            if (fileProcessorStream.saveArrayToFile(fPathOutput, Collections.unmodifiableList(numProc.getNumbersAndSums(unmodArrayFromFile)))) {
                success = true;
            }
        }
        return success;
    }
}
