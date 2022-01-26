package Crypt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileAccessTest {

    private final String fileOutName = "build/resources/test/fileOutputTest.txt";
    private final String fileInputName = "build/resources/test/fileInTest.txt";
    private final String multiLineFileName = "build/resources/test/multiLine.txt";

    @Test
    void fileInReturnsInput() {
        assertEquals("test", FileAccess.getInputFromFile(fileInputName));
    }

    @Test
    void multiLineFileInIsCorrect() {
        assertEquals("frank grimes is cool", FileAccess.getInputFromFile(multiLineFileName));
    }

    @Test
    void fileOutIsCorrect() {
        String test = "Frank Grimes is Cool";
        FileAccess.setOutputToFile(test, fileOutName);
        String result = FileAccess.getInputFromFile(fileOutName);

        assertEquals(test, result);
    }
}
