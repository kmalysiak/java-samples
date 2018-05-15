package pl.coderstrust.multiplication;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) {
        MultiplicationTable table = new MultiplicationTable();
        String outputPath = "src\\test\\resources\\pl.coderstrust\\multiplication\\multiplpication.txt";
        try (PrintStream fileOutput = new PrintStream(new FileOutputStream(outputPath))) {
            System.setOut(fileOutput);
            table.printMultiplicationTable(1);
            table.printMultiplicationTable(15);
            table.printMultiplicationTable(104);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
