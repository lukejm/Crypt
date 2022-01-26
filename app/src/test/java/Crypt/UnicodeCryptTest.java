package Crypt;

import Crypt.crypt.CryptType;
import Crypt.crypt.UnicodeCrypt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnicodeCryptTest {

    @Test
    void getOutputReturns() {
        assertEquals("Frank", new UnicodeCrypt("Frank", 5).getOutput());
    }

    @Test
    void encryptWithKeyEqualToOne() {
        assertEquals("bcdefg", new UnicodeCrypt("abcdef", 1).getOutput(CryptType.ENCRYPT));
    }

    @Test
    void decryptWithKeyEqualToOne() {
        assertEquals("abcdef", new UnicodeCrypt("bcdefg", 1).getOutput(CryptType.DECRYPT));
    }

    @Test
    void decrypt() {
        assertEquals("Welcome to hyperskill!", new UnicodeCrypt("\\jqhtrj%yt%m~ujwxpnqq&", 5).getOutput(CryptType.DECRYPT));
    }

    @Test
    void encrypt() {
        assertEquals("\\jqhtrj%yt%m~ujwxpnqq&", new UnicodeCrypt("Welcome to hyperskill!", 5).getOutput(CryptType.ENCRYPT));
    }
}
