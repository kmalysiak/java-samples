package pl.coderstrust.pascal_triangle;

public class PascalTriangle {
    private final static int MAX_ROWS = 61;

    private String spacesFormat;
    private String coefficientFormat;

    public void printPascalTriangle(int rows) {
        if (rows > MAX_ROWS || rows < 0) {
            System.out.println("Parameter row :" + rows + " out of bounds. Should be from range [0," + MAX_ROWS + ")");
            return;
        } else {
            setPrintingFormats((String.valueOf(binomialCoefficient(rows, (rows) / 2)).length()) / 2 + 1);
            for (int n = 0; n <= rows; n++) {
                for (int i = n; i <= rows; i++) {
                    System.out.print(String.format(spacesFormat, " "));
                }
                for (int k = 0; k <= n; k++) {
                    System.out.print(String.format(coefficientFormat, binomialCoefficient(n, k)));
                }
                System.out.print(System.lineSeparator());
            }
        }
    }

    private void setPrintingFormats(int maxHalfNumDigits) {
        spacesFormat = "%" + maxHalfNumDigits + "s";
        coefficientFormat = "%" + 2 * maxHalfNumDigits + "d";
    }

    private long binomialCoefficient(int n, int k) throws ArithmeticException {
        long result = 1;
        for (int i = 1; i <= k; ++i) {
            result = Math.multiplyExact(result, (long) (n + 1 - i));
            result /= (long) (i);
        }
        return result;
    }
}