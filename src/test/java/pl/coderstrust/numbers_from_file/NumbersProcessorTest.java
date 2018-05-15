package pl.coderstrust.numbers_from_file;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public abstract class NumbersProcessorTest {

    public abstract GeneralNumbersProcessor getNumbersProcessor();

    @Test
    @Parameters(method = "parametersForTestMethod")
    public void shouldReturnStringWithCorrectSum(List<Integer[]> input, String result) {
        List<String> test1 = getNumbersProcessor().getNumbersAndSums(input);
        assertEquals(test1.get(0), result);
    }

    @SuppressWarnings("unused")
    private Object[] parametersForTestMethod() {
        List<Integer[]> input1 = new ArrayList<>();
        List<Integer[]> input2 = new ArrayList<>();
        input1.add(new Integer[]{1, 2, 3});
        input2.add(new Integer[]{3, 1, 111});
        return $($(input1, "1+2+3=6"), $(input2, "3+1+111=115"));
    }

    @Test
    public void shouldReturnZeroSizeListForZeroSizeListInput() {
        List<Integer[]> input = new ArrayList<>();
        List<String> output = getNumbersProcessor().getNumbersAndSums(input);
        assertEquals(input.size(), output.size());


    }
}