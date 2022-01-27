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

public class ShiftCryptTest {

    private final String fileOutput = "build/resources/test/fileOutTest.test.txt";

    @Test
    void outputTextCorrectDecrypt() {
        new CryptBuilder.Builder().data("Frank").key("0").outFile(fileOutput).build().run();
        assertEquals("Frank", FileAccess.getInputFromFile(fileOutput));
    }

    @Test
    void outputTextShiftCorrectAroundAtoZShiftOneLowerCaseDecrypt() {
        new CryptBuilder.Builder().data("zabcde").key("1").outFile(fileOutput).typeAlgorithm(TypeAlgorithm.SHIFT).typeCrypt(TypeCrypt.DECRYPT).build().run();
        assertEquals("yzabcd", FileAccess.getInputFromFile(fileOutput));
    }

    @Test
    void outputTextShiftCorrectAroundAtoZShiftOneUpperCaseDecrypt() {
        new CryptBuilder.Builder().data("ABCDEF").key("1").outFile(fileOutput).typeAlgorithm(TypeAlgorithm.SHIFT).typeCrypt(TypeCrypt.DECRYPT).build().run();
        assertEquals("ZABCDE", FileAccess.getInputFromFile(fileOutput));
    }

    @Test
    void outputTextShiftCorrectShiftOneLowerCaseDecrypt() {
        new CryptBuilder.Builder().data("cdefgh").key("1").outFile(fileOutput).typeAlgorithm(TypeAlgorithm.SHIFT).typeCrypt(TypeCrypt.DECRYPT).build().run();
        assertEquals("bcdefg", FileAccess.getInputFromFile(fileOutput));
    }

    @Test
    void outputTextShiftCorrectShiftOneUpperCaseDecrypt() {
        new CryptBuilder.Builder().data("CDEFGH").key("1").outFile(fileOutput).typeAlgorithm(TypeAlgorithm.SHIFT).typeCrypt(TypeCrypt.DECRYPT).build().run();
        assertEquals("BCDEFG", FileAccess.getInputFromFile(fileOutput));
    }

    @Test
    void shiftByWholeAlphabetLowerCaseDecrypt() {
        new CryptBuilder.Builder().data("abcdef").key("26").outFile(fileOutput).typeAlgorithm(TypeAlgorithm.SHIFT).typeCrypt(TypeCrypt.DECRYPT).build().run();
        assertEquals("abcdef", FileAccess.getInputFromFile(fileOutput));
    }

    @Test
    void shiftByWholeAlphabetUpperCaseDecrypt() {
        new CryptBuilder.Builder().data("ABCDEF").key("26").outFile(fileOutput).typeAlgorithm(TypeAlgorithm.SHIFT).typeCrypt(TypeCrypt.DECRYPT).build().run();
        assertEquals("ABCDEF", FileAccess.getInputFromFile(fileOutput));
    }

    @Test
    void shiftSpecialCharactersDecrypt() {
        new CryptBuilder.Builder().data("c!?@#$ ").key("1").outFile(fileOutput).typeAlgorithm(TypeAlgorithm.SHIFT).typeCrypt(TypeCrypt.DECRYPT).build().run();
        assertEquals("b!?@#$ ", FileAccess.getInputFromFile(fileOutput));
    }

    @Test
    void outputTextCorrectEncrypt() {
        new CryptBuilder.Builder().data("Frank").key("0").outFile(fileOutput).typeAlgorithm(TypeAlgorithm.SHIFT).typeCrypt(TypeCrypt.ENCRYPT).build().run();
        assertEquals("Frank", FileAccess.getInputFromFile(fileOutput));
    }

    @Test
    void outputTextShiftCorrectAroundAtoZShiftOneLowerCaseEncrypt() {
        new CryptBuilder.Builder().data("yzabcd").key("1").outFile(fileOutput).typeAlgorithm(TypeAlgorithm.SHIFT).typeCrypt(TypeCrypt.ENCRYPT).build().run();
        assertEquals("zabcde", FileAccess.getInputFromFile(fileOutput));
    }

    @Test
    void outputTextShiftCorrectAroundAtoZShiftOneUpperCaseEncrypt() {
        new CryptBuilder.Builder().data("YZABCD").key("1").outFile(fileOutput).typeAlgorithm(TypeAlgorithm.SHIFT).typeCrypt(TypeCrypt.ENCRYPT).build().run();
        assertEquals("ZABCDE", FileAccess.getInputFromFile(fileOutput));
    }

    @Test
    void outputTextShiftCorrectShiftOneLowerCaseEncrypt() {
        new CryptBuilder.Builder().data("bcdefg").key("1").outFile(fileOutput).typeAlgorithm(TypeAlgorithm.SHIFT).typeCrypt(TypeCrypt.ENCRYPT).build().run();
        assertEquals("cdefgh", FileAccess.getInputFromFile(fileOutput));
    }

    @Test
    void outputTextShiftCorrectShiftOneUpperCaseEncrypt() {
        new CryptBuilder.Builder().data("BCDEFG").key("1").outFile(fileOutput).typeAlgorithm(TypeAlgorithm.SHIFT).typeCrypt(TypeCrypt.ENCRYPT).build().run();
        assertEquals("CDEFGH", FileAccess.getInputFromFile(fileOutput));
    }

    @Test
    void shiftByWholeAlphabetLowerCaseEncrypt() {
        new CryptBuilder.Builder().data("abcdef").key("26").outFile(fileOutput).typeAlgorithm(TypeAlgorithm.SHIFT).typeCrypt(TypeCrypt.ENCRYPT).build().run();
        assertEquals("abcdef", FileAccess.getInputFromFile(fileOutput));
    }

    @Test
    void shiftByWholeAlphabetUpperCaseEncrypt() {
        new CryptBuilder.Builder().data("ABCDEF").key("26").outFile(fileOutput).typeAlgorithm(TypeAlgorithm.SHIFT).typeCrypt(TypeCrypt.ENCRYPT).build().run();
        assertEquals("ABCDEF", FileAccess.getInputFromFile(fileOutput));
    }

    @Test
    void shiftSpecialCharactersEncrypt() {
        new CryptBuilder.Builder().data("c!?@#$ ").key("1").outFile(fileOutput).typeAlgorithm(TypeAlgorithm.SHIFT).typeCrypt(TypeCrypt.ENCRYPT).build().run();
        assertEquals("d!?@#$ ", FileAccess.getInputFromFile(fileOutput));
    }

    @Test
    void encryptDecryptTest() {
        String text = "frank grimes !!!!";
        new CryptBuilder.Builder().data(text).key("20").outFile(fileOutput).typeAlgorithm(TypeAlgorithm.SHIFT).typeCrypt(TypeCrypt.ENCRYPT).build().run();
        String enc = FileAccess.getInputFromFile(fileOutput);
        new CryptBuilder.Builder().data(enc).key("20").outFile(fileOutput).typeAlgorithm(TypeAlgorithm.SHIFT).typeCrypt(TypeCrypt.DECRYPT).build().run();
        assertEquals(text, FileAccess.getInputFromFile(fileOutput));
    }
}