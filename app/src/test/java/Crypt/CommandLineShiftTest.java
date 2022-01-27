package Crypt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandLineShiftTest {
    String shiftBaseDec = "build/resources/test/fileInTest.dec.shift.test.txt";
    String shiftBaseEnc = "build/resources/test/fileInTest.enc.shift.test.txt";

    String[] argOne = {"-in",
            "build/resources/test/fileInTest.dec.shift.test.txt",
            "-out",
            "build/resources/test/fileOutTest.enc.shift.result",
            "-key",
            "5",
            "-alg",
            "shift",
            "-mode",
            "enc"};

    String[] argTwo = {"-in",
            "build/resources/test/fileInTest.enc.shift.test.txt",
            "-out",
            "build/resources/test/fileOutTest.dec.shift.result",
            "-key",
            "5",
            "-alg",
            "shift",
            "-mode",
            "dec"};


    @Test
    void testArgOne() {
        CommandLine.run(argOne);
        assertEquals(FileAccess.getInputFromFile(shiftBaseEnc),
                FileAccess.getInputFromFile("build/resources/test/fileOutTest.enc.shift.result"));
    }

    @Test
    void testArgTwo() {
        CommandLine.run(argTwo);
        assertEquals(FileAccess.getInputFromFile(shiftBaseDec),
                FileAccess.getInputFromFile("build/resources/test/fileOutTest.dec.shift.result"));
    }
}
