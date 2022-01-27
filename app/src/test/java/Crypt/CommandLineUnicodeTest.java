package Crypt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandLineUnicodeTest {

    String unicodeBaseDec = "build/resources/test/fileInTest.dec.unicode.test.txt";
    String unicodeBaseEnc = "build/resources/test/fileInTest.enc.unicode.test.txt";

    String[] argOne = {"-in",
            "build/resources/test/fileInTest.dec.unicode.test.txt",
            "-out",
            "build/resources/test/fileOutTest.enc.unicode.result",
            "-key",
            "5",
            "-alg",
            "unicode",
            "-mode",
            "enc"};

    String[] argTwo = {"-in",
            "build/resources/test/fileInTest.enc.unicode.test.txt",
            "-out",
            "build/resources/test/fileOutTest.dec.unicode.result",
            "-key",
            "5",
            "-alg",
            "unicode",
            "-mode",
            "dec"};


    @Test
    void testArgOne() {
        CommandLine.run(argOne);
        assertEquals(FileAccess.getInputFromFile(unicodeBaseEnc),
                FileAccess.getInputFromFile("build/resources/test/fileOutTest.enc.unicode.result"));
    }

    @Test
    void testArgTwo() {
        CommandLine.run(argTwo);
        assertEquals(FileAccess.getInputFromFile(unicodeBaseDec),
                FileAccess.getInputFromFile("build/resources/test/fileOutTest.dec.unicode.result"));
    }
}
