package pl.coderstrust.numbers_from_file;

import pl.coderstrust.numbers_from_file.stream.FileProcessorStream;
import pl.coderstrust.numbers_from_file.stream.ProcessorStream;

public class ProcessorStreamTest extends ProcessorTest {

    @Override
    public GeneralProcessor getProcessor() {
        return new ProcessorStream(new FileProcessorStream());
    }
}
