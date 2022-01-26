package Crypt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileInTest {

    private final String fileName = "build/resources/test/fileInTest.txt";

    @Test
    void fileInReturnsInput() {
        assertEquals("test", FileIn.getInputFromFile(fileName));
    }
}
