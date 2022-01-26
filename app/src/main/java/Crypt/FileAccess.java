package Crypt;

import java.io.*;

public class FileAccess {

    public static String getInputFromFile(String fileName) {
        return inFile(fileName);
    }

    public static void setOutputToFile(String text, String fileName) {
        outFile(text, fileName);
    }

    private static String inFile(String fileName) {
        String line = "";
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException ex) {
            System.err.println("Error: file input.");
        }
        return sb.toString();
    }

    private static void outFile(String text, String fileName) {
        try (PrintWriter pw = new PrintWriter(fileName)) {
            pw.println(text);
        } catch (IOException ex) {
            System.err.println("Error: file output.");
        }
    }
}
