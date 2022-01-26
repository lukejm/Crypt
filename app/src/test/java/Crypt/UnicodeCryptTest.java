package Crypt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnicodeCryptTest {

    @Test
    void encryptWithKeyEqualToOne() {
        Crypt c = new UnicodeCrypt.Builder().input("abcdef").key(1).build();
        assertEquals("bcdefg", c.getOutput(TypeCrypt.ENCRYPT));
    }

    @Test
    void decryptWithKeyEqualToOne() {
        Crypt c = new UnicodeCrypt.Builder().input("bcdefg").key(1).build();
        assertEquals("abcdef", c.getOutput(TypeCrypt.DECRYPT));
    }

    @Test
    void decrypt() {
        Crypt c = new UnicodeCrypt.Builder().input("\\jqhtrj%yt%m~ujwxpnqq&").key(5).build();
        assertEquals("Welcome to hyperskill!", c.getOutput(TypeCrypt.DECRYPT));
    }

    @Test
    void encrypt() {
        Crypt c = new UnicodeCrypt.Builder().input("Welcome to hyperskill!").key(5).build();
        assertEquals("\\jqhtrj%yt%m~ujwxpnqq&", c.getOutput(TypeCrypt.ENCRYPT));
    }

    @Test
    void encryptDecrypt() {
        String message = "Frank Grimes !!!";
        int key = 10;
        Crypt encC = new UnicodeCrypt.Builder().input(message).key(10).build();
        String encText = encC.getOutput(TypeCrypt.ENCRYPT);
        Crypt decD = new UnicodeCrypt.Builder().input(encText).key(10).build();
        assertEquals(message, decD.getOutput(TypeCrypt.DECRYPT));
    }

    @Test
    void noInputTestEncrypt() {
        Crypt c = new UnicodeCrypt.Builder().build();
        assertEquals("", c.getOutput(TypeCrypt.ENCRYPT));
    }

    @Test
    void noInputTestDecryption() {
        Crypt c = new UnicodeCrypt.Builder().build();
        assertEquals("", c.getOutput(TypeCrypt.DECRYPT));
    }
}
