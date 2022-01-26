package Crypt;

import java.io.*;

public class FileIn extends FileProcessing {

    public static String getInputFromFile(String fileName) {
        return processFile(fileName);
    }

    private static String processFile(String fileName) {
        String text = "";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            text = br.readLine();
        } catch (IOException ex) {
            System.err.println("Error: file input.");
        }
        return text;
    }
}
