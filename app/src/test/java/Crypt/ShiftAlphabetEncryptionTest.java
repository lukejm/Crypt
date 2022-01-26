package Crypt;

import Crypt.crypt.ShiftAlphabetEncryption;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShiftAlphabetEncryptionTest {

    @Test
    void outputTextCorrect() {
        assertEquals("Frank", new ShiftAlphabetEncryption("Frank", 0).getOutput());
    }

    @Test
    void outputTextShiftCorrectAroundAtoZShiftOneLowerCase() {
        assertEquals("zabcde", new ShiftAlphabetEncryption("yzabcd", 1).getOutput());
    }

    @Test
    void outputTextShiftCorrectAroundAtoZShiftOneUpperCase() {
        assertEquals("ZABCDE", new ShiftAlphabetEncryption("YZABCD", 1).getOutput());

    }

    @Test
    void outputTextShiftCorrectShiftOneLowerCase() {
        assertEquals("cdefgh", new ShiftAlphabetEncryption("bcdefg",  1).getOutput());
    }

    @Test
    void outputTextShiftCorrectShiftOneUpperCase() {
        assertEquals("CDEFGH", new ShiftAlphabetEncryption("BCDEFG",  1).getOutput());
    }

    @Test
    void shiftByWholeAlphabetLowerCase() {
        assertEquals("abcdef", new ShiftAlphabetEncryption("abcdef", 26).getOutput());
    }

    @Test
    void shiftByWholeAlphabetUpperCase() {
        assertEquals("ABCDEF", new ShiftAlphabetEncryption("ABCDEF", 26).getOutput());
    }

    @Test
    void shiftSpecialCharacters() {
        assertEquals("d!?@#$ ", new ShiftAlphabetEncryption("c!?@#$ ", 1).getOutput());
    }
}
