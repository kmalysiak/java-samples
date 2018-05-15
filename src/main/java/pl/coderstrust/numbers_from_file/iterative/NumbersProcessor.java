package pl.coderstrust.numbers_from_file.iterative;

import pl.coderstrust.numbers_from_file.GeneralNumbersProcessor;

import java.util.ArrayList;
import java.util.List;


public class NumbersProcessor implements GeneralNumbersProcessor {
    public List<String> getNumbersAndSums(List<Integer[]> arrayFromFile) {
        List<String> numbersAndSums = new ArrayList<>();
        for (Integer[] numbersToSum : arrayFromFile) {
            numbersAndSums.add(sumLine(numbersToSum));
        }
        return numbersAndSums;
    }

    private String sumLine(Integer[] numbersToSum) {
        StringBuilder stringBuilder = new StringBuilder();
        Integer sum = 0;
        for (Integer number : numbersToSum) {
            stringBuilder.append(number.toString() + "+");
            sum += number;
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append("=" + sum.toString());
        return stringBuilder.toString();
    }
}
