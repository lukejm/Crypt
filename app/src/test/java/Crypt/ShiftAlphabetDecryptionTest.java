package Crypt;

import Crypt.crypt.ShiftAlphabetDecryption;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShiftAlphabetDecryptionTest {

    @Test
    void outputTextCorrect() {
        assertEquals("Frank", new ShiftAlphabetDecryption("Frank", 0).getOutput());
    }

    @Test
    void outputTextShiftCorrectAroundAtoZShiftOneLowerCase() {
        assertEquals("yzabcd", new ShiftAlphabetDecryption("zabcde", 1).getOutput());
    }

    @Test
    void outputTextShiftCorrectAroundAtoZShiftOneUpperCase() {
        assertEquals("ZABCDE", new ShiftAlphabetDecryption("ABCDEF", 1).getOutput());

    }

    @Test
    void outputTextShiftCorrectShiftOneLowerCase() {
        assertEquals("bcdefg", new ShiftAlphabetDecryption("cdefgh",  1).getOutput());
    }

    @Test
    void outputTextShiftCorrectShiftOneUpperCase() {
        assertEquals("BCDEFG", new ShiftAlphabetDecryption("CDEFGH",  1).getOutput());
    }

    @Test
    void shiftByWholeAlphabetLowerCase() {
        assertEquals("abcdef", new ShiftAlphabetDecryption("abcdef", 26).getOutput());
    }

    @Test
    void shiftByWholeAlphabetUpperCase() {
        assertEquals("ABCDEF", new ShiftAlphabetDecryption("ABCDEF", 26).getOutput());
    }

    @Test
    void shiftSpecialCharacters() {
        assertEquals("b!?@#$ ", new ShiftAlphabetDecryption("c!?@#$ ", 1).getOutput());
    }
}
