package pl.coderstrust.numbers_from_file;

import pl.coderstrust.numbers_from_file.stream.FileProcessorStream;

public class FileProcessorStreamTest extends FileProcessorTest {

    @Override
    public GeneralFileProcessor getFileProcessor() {
        return new FileProcessorStream();
    }
}

