/**
 *
 * Luke James Mitton
 * luke.j.mitton@gmail.com
 * https://github.com/lukejm
 *
 */
package Crypt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandLineGeneralTest {

    String generalBaseDec = "build/resources/test/fileInTest.dec.general.test.txt";
    String generalBaseEnc = "build/resources/test/fileInTest.enc.general.test.txt";

    String[] argOne = {"-data",
            "Homer Simpson is super cool!!!",
            "-out",
            "build/resources/test/fileOutTest.enc.general.result",
            "-key",
            "5",
            "-alg",
            "shift",
            "-mode",
            "enc"};

    String[] argTwo = {"-data",
            "Mtrjw Xnruxts nx xzujw httq!!!",
            "-out",
            "build/resources/test/fileOutTest.dec.general.result",
            "-key",
            "5",
            "-alg",
            "unicode",
            "-mode",
            "dec"};

    @Test
    void testArgOne() {
        CommandLine.run(argOne);
        assertEquals(FileAccess.getInputFromFile(generalBaseEnc),
                FileAccess.getInputFromFile("build/resources/test/fileOutTest.enc.general.result"));
    }
//
//    @Test
//    void testArgTwo() {
//        CommandLine.run(argTwo);
//        assertEquals(FileAccess.getInputFromFile(generalBaseDec),
//                FileAccess.getInputFromFile("build/resources/test/fileOutTest.dec.general.result"));
//    }

}
