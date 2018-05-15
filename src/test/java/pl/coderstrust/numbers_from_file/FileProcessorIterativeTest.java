package pl.coderstrust.numbers_from_file;

import pl.coderstrust.numbers_from_file.iterative.FileProcessor;

public class FileProcessorIterativeTest extends FileProcessorTest {

    @Override
    public GeneralFileProcessor getFileProcessor() {
        return new FileProcessor();
    }
}
