package pl.coderstrust.new_in_java.java7_try_with_resources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String path = "src\\main\\java\\pl\\coderstrustt\\new_in_java\\java7_try_with_resources\\Main.java";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            System.out.println(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}