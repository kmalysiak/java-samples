package pl.coderstrust.numbers_from_file;

import pl.coderstrust.numbers_from_file.iterative.NumbersProcessor;

public class NumberProcessorIterativeTest extends NumbersProcessorTest {

    @Override
    public GeneralNumbersProcessor getNumbersProcessor() {
        return new NumbersProcessor();
    }
}
