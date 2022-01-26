package Crypt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnicodeCryptTest {

    @Test
    void encryptWithKeyEqualToOne() {
        Crypt c = new UnicodeCrypt.Builder().input("abcdef").key(1).build();
        assertEquals("bcdefg", c.getOutput(CryptType.ENCRYPT));
    }

    @Test
    void decryptWithKeyEqualToOne() {
        Crypt c = new UnicodeCrypt.Builder().input("bcdefg").key(1).build();
        assertEquals("abcdef", c.getOutput(CryptType.DECRYPT));
    }

    @Test
    void decrypt() {
        Crypt c = new UnicodeCrypt.Builder().input("\\jqhtrj%yt%m~ujwxpnqq&").key(5).build();
        assertEquals("Welcome to hyperskill!", c.getOutput(CryptType.DECRYPT));
    }

    @Test
    void encrypt() {
        Crypt c = new UnicodeCrypt.Builder().input("Welcome to hyperskill!").key(5).build();
        assertEquals("\\jqhtrj%yt%m~ujwxpnqq&", c.getOutput(CryptType.ENCRYPT));
    }

    @Test
    void encryptDecrypt() {
        String message = "Frank Grimes !!!";
        int key = 10;
        Crypt encC = new UnicodeCrypt.Builder().input(message).key(10).build();
        String encText = encC.getOutput(CryptType.ENCRYPT);
        Crypt decD = new UnicodeCrypt.Builder().input(encText).key(10).build();
        assertEquals(message, decD.getOutput(CryptType.DECRYPT));
    }

    @Test
    void noInputTestEncrypt() {
        Crypt c = new UnicodeCrypt.Builder().build();
        assertEquals("", c.getOutput(CryptType.ENCRYPT));
    }

    @Test
    void noInputTestDecryption() {
        Crypt c = new UnicodeCrypt.Builder().build();
        assertEquals("", c.getOutput(CryptType.DECRYPT));
    }
}
