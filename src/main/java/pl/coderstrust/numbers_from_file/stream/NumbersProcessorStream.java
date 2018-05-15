package pl.coderstrust.numbers_from_file.stream;

import pl.coderstrust.numbers_from_file.GeneralNumbersProcessor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumbersProcessorStream implements GeneralNumbersProcessor {

    public List<String> getNumbersAndSums(List<Integer[]> arrayFromFile) {
        Stream<Integer[]> rawIntegerInput = arrayFromFile.stream();

        return rawIntegerInput
                .map(line -> sumLine(line))
                .collect(Collectors.toList());
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
