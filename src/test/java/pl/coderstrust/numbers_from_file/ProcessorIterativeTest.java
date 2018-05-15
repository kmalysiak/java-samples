package pl.coderstrust.numbers_from_file;

import pl.coderstrust.numbers_from_file.iterative.FileProcessor;
import pl.coderstrust.numbers_from_file.iterative.Processor;

public class ProcessorIterativeTest extends ProcessorTest {

    @Override
    public GeneralProcessor getProcessor() {
        return new Processor(new FileProcessor());
    }
}
