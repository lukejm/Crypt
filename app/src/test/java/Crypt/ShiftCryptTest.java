package Crypt;

import Crypt.crypt.CryptType;
import Crypt.crypt.ShiftCrypt;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShiftCryptTest {

    @Test
    void outputTextCorrectDecrypt() {
        assertEquals("Frank", new ShiftCrypt("Frank", 0).getOutput(CryptType.DECRYPT));
    }

    @Test
    void outputTextShiftCorrectAroundAtoZShiftOneLowerCaseDecrypt() {
        assertEquals("yzabcd", new ShiftCrypt("zabcde", 1).getOutput(CryptType.DECRYPT));
    }

    @Test
    void outputTextShiftCorrectAroundAtoZShiftOneUpperCaseDecrypt() {
        assertEquals("ZABCDE", new ShiftCrypt("ABCDEF", 1).getOutput(CryptType.DECRYPT));

    }

    @Test
    void outputTextShiftCorrectShiftOneLowerCaseDecrypt() {
        assertEquals("bcdefg", new ShiftCrypt("cdefgh",  1).getOutput(CryptType.DECRYPT));
    }

    @Test
    void outputTextShiftCorrectShiftOneUpperCaseDecrypt() {
        assertEquals("BCDEFG", new ShiftCrypt("CDEFGH",  1).getOutput(CryptType.DECRYPT));
    }

    @Test
    void shiftByWholeAlphabetLowerCaseDecrypt() {
        assertEquals("abcdef", new ShiftCrypt("abcdef", 26).getOutput(CryptType.DECRYPT));
    }

    @Test
    void shiftByWholeAlphabetUpperCaseDecrypt() {
        assertEquals("ABCDEF", new ShiftCrypt("ABCDEF", 26).getOutput(CryptType.DECRYPT));
    }

    @Test
    void shiftSpecialCharactersDecrypt() {
        assertEquals("b!?@#$ ", new ShiftCrypt("c!?@#$ ", 1).getOutput(CryptType.DECRYPT));
    }

    @Test
    void outputTextCorrectEncrypt() {
        assertEquals("Frank", new ShiftCrypt("Frank", 0).getOutput(CryptType.ENCRYPT));
    }

    @Test
    void outputTextShiftCorrectAroundAtoZShiftOneLowerCaseEncrypt() {
        assertEquals("zabcde", new ShiftCrypt("yzabcd", 1).getOutput(CryptType.ENCRYPT));
    }

    @Test
    void outputTextShiftCorrectAroundAtoZShiftOneUpperCaseEncrypt() {
        assertEquals("ZABCDE", new ShiftCrypt("YZABCD", 1).getOutput(CryptType.ENCRYPT));

    }

    @Test
    void outputTextShiftCorrectShiftOneLowerCaseEncrypt() {
        assertEquals("cdefgh", new ShiftCrypt("bcdefg",  1).getOutput(CryptType.ENCRYPT));
    }

    @Test
    void outputTextShiftCorrectShiftOneUpperCaseEncrypt() {
        assertEquals("CDEFGH", new ShiftCrypt("BCDEFG",  1).getOutput(CryptType.ENCRYPT));
    }

    @Test
    void shiftByWholeAlphabetLowerCaseEncrypt() {
        assertEquals("abcdef", new ShiftCrypt("abcdef", 26).getOutput(CryptType.ENCRYPT));
    }

    @Test
    void shiftByWholeAlphabetUpperCaseEncrypt() {
        assertEquals("ABCDEF", new ShiftCrypt("ABCDEF", 26).getOutput(CryptType.ENCRYPT));
    }

    @Test
    void shiftSpecialCharactersEncrypt() {
        assertEquals("d!?@#$ ", new ShiftCrypt("c!?@#$ ", 1).getOutput(CryptType.ENCRYPT));
    }
}