package pl.coderstrust.numbers_from_file;

import pl.coderstrust.numbers_from_file.iterative.NumbersProcessor;

public class NumbersProcessorStreamTest extends NumbersProcessorTest {

    @Override
    public GeneralNumbersProcessor getNumbersProcessor() {
        return new NumbersProcessor();
    }

}
