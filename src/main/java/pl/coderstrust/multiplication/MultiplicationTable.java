package pl.coderstrust.multiplication;

public class MultiplicationTable {
    private String spacesFormat;
    private String integerFormat;

    public void printMultiplicationTable(int size) {

        if (size > 0) {
            setPrintingFormats(String.valueOf(size * size).length() / 2 + 1);
            System.out.print(String.format(spacesFormat, " "));

            for (int i = 1; i <= size; i++) {
                System.out.print(String.format(integerFormat, i));
            }
            System.out.println();
            for (int i = 1; i <= size; i++) {
                System.out.print(String.format(integerFormat, i));
                for (int j = 1; j <= size; j++) {
                    System.out.print(String.format(integerFormat, i * j));
                }
                System.out.println();
            }
        }
    }

    private void setPrintingFormats(int maxHalfNumDigits) {
        spacesFormat = "%" + 2 * maxHalfNumDigits + "s";
        integerFormat = "%" + 2 * maxHalfNumDigits + "d";
    }
}