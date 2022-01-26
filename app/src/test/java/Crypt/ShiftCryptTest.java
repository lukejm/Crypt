package Crypt;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShiftCryptTest {

    @Test
    void outputTextCorrectDecrypt() {
        Crypt c = new ShiftCrypt.Builder().input("Frank").shift(0).build();
        assertEquals("Frank", c.getOutput(CryptType.DECRYPT));
    }

    @Test
    void outputTextShiftCorrectAroundAtoZShiftOneLowerCaseDecrypt() {
        Crypt c = new ShiftCrypt.Builder().input("zabcde").shift(1).build();
        assertEquals("yzabcd", c.getOutput(CryptType.DECRYPT));
    }

    @Test
    void outputTextShiftCorrectAroundAtoZShiftOneUpperCaseDecrypt() {
        Crypt c = new ShiftCrypt.Builder().input("ABCDEF").shift(1).build();
        assertEquals("ZABCDE", c.getOutput(CryptType.DECRYPT));

    }

    @Test
    void outputTextShiftCorrectShiftOneLowerCaseDecrypt() {
        Crypt c = new ShiftCrypt.Builder().input("cdefgh").shift(1).build();
        assertEquals("bcdefg", c.getOutput(CryptType.DECRYPT));
    }

    @Test
    void outputTextShiftCorrectShiftOneUpperCaseDecrypt() {
        Crypt c = new ShiftCrypt.Builder().input("CDEFGH").shift(1).build();
        assertEquals("BCDEFG", c.getOutput(CryptType.DECRYPT));
    }

    @Test
    void shiftByWholeAlphabetLowerCaseDecrypt() {
        Crypt c = new ShiftCrypt.Builder().input("abcdef").shift(26).build();
        assertEquals("abcdef", c.getOutput(CryptType.DECRYPT));
    }

    @Test
    void shiftByWholeAlphabetUpperCaseDecrypt() {
        Crypt c = new ShiftCrypt.Builder().input("ABCDEF").shift(26).build();
        assertEquals("ABCDEF", c.getOutput(CryptType.DECRYPT));
    }

    @Test
    void shiftSpecialCharactersDecrypt() {
        Crypt c = new ShiftCrypt.Builder().input("c!?@#$ ").shift(1).build();
        assertEquals("b!?@#$ ", c.getOutput(CryptType.DECRYPT));
    }

    @Test
    void outputTextCorrectEncrypt() {
        Crypt c = new ShiftCrypt.Builder().input("Frank").shift(0).build();
        assertEquals("Frank", c.getOutput(CryptType.ENCRYPT));
    }

    @Test
    void outputTextShiftCorrectAroundAtoZShiftOneLowerCaseEncrypt() {
        Crypt c = new ShiftCrypt.Builder().input("yzabcd").shift(1).build();
        assertEquals("zabcde", c.getOutput(CryptType.ENCRYPT));
    }

    @Test
    void outputTextShiftCorrectAroundAtoZShiftOneUpperCaseEncrypt() {
        Crypt c = new ShiftCrypt.Builder().input("YZABCD").shift(1).build();
        assertEquals("ZABCDE", c.getOutput(CryptType.ENCRYPT));
    }

    @Test
    void outputTextShiftCorrectShiftOneLowerCaseEncrypt() {
        Crypt c = new ShiftCrypt.Builder().input("bcdefg").shift(1).build();
        assertEquals("cdefgh", c.getOutput(CryptType.ENCRYPT));
    }

    @Test
    void outputTextShiftCorrectShiftOneUpperCaseEncrypt() {
        Crypt c = new ShiftCrypt.Builder().input("BCDEFG").shift(1).build();
        assertEquals("CDEFGH", c.getOutput(CryptType.ENCRYPT));
    }

    @Test
    void shiftByWholeAlphabetLowerCaseEncrypt() {
        Crypt c = new ShiftCrypt.Builder().input("abcdef").shift(26).build();
        assertEquals("abcdef", c.getOutput(CryptType.ENCRYPT));
    }

    @Test
    void shiftByWholeAlphabetUpperCaseEncrypt() {
        Crypt c = new ShiftCrypt.Builder().input("ABCDEF").shift(26).build();
        assertEquals("ABCDEF", c.getOutput(CryptType.ENCRYPT));
    }

    @Test
    void shiftSpecialCharactersEncrypt() {
        Crypt c = new ShiftCrypt.Builder().input("c!?@#$ ").shift(1).build();
        assertEquals("d!?@#$ ", c.getOutput(CryptType.ENCRYPT));
    }

    @Test
    void encryptDecryptTest() {
        String text = "frank grimes !!!!";
        Crypt encC = new ShiftCrypt.Builder().input(text).shift(20).build();
        String enc = encC.getOutput(CryptType.ENCRYPT);
        Crypt decC = new ShiftCrypt.Builder().input(enc).shift(20).build();
        assertEquals(text, decC.getOutput(CryptType.DECRYPT));
    }

    @Test
    void noInputTestEncrypt() {
        Crypt c = new ShiftCrypt.Builder().build();
        assertEquals("", c.getOutput(CryptType.ENCRYPT));
    }

    @Test
    void noInputTestDecryption() {
        Crypt c = new ShiftCrypt.Builder().build();
        assertEquals("", c.getOutput(CryptType.DECRYPT));
    }
}