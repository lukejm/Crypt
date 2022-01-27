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

public class UnicodeCryptTest {

    private final String fileOutput = "build/resources/test/fileOutTest.test.txt";

    @Test
    void encryptWithKeyEqualToOne() {
        new CryptBuilder.Builder().data("abcdef").key("1").outFile(fileOutput).typeCrypt(TypeCrypt.ENCRYPT).typeAlgorithm(TypeAlgorithm.UNICODE).build().run();
        assertEquals("bcdefg", FileAccess.getInputFromFile(fileOutput));
    }

    @Test
    void decryptWithKeyEqualToOne() {
        new CryptBuilder.Builder().data("bcdefg").key("1").outFile(fileOutput).typeCrypt(TypeCrypt.DECRYPT).typeAlgorithm(TypeAlgorithm.UNICODE).build().run();
        assertEquals("abcdef", FileAccess.getInputFromFile(fileOutput));
    }

    @Test
    void decrypt() {
        new CryptBuilder.Builder().data("\\jqhtrj%yt%m~ujwxpnqq&").key("5").outFile(fileOutput).typeCrypt(TypeCrypt.DECRYPT).typeAlgorithm(TypeAlgorithm.UNICODE).build().run();
        assertEquals("Welcome to hyperskill!", FileAccess.getInputFromFile(fileOutput));
    }

    @Test
    void encrypt() {
        new CryptBuilder.Builder().data("Welcome to hyperskill!").key("5").outFile(fileOutput).typeCrypt(TypeCrypt.ENCRYPT).typeAlgorithm(TypeAlgorithm.UNICODE).build().run();
        assertEquals("\\jqhtrj%yt%m~ujwxpnqq&", FileAccess.getInputFromFile(fileOutput));
    }

    @Test
    void encryptDecrypt() {
        String message = "Frank Grimes !!!";
        new CryptBuilder.Builder().data(message).typeCrypt(TypeCrypt.ENCRYPT).key("10").outFile(fileOutput).typeAlgorithm(TypeAlgorithm.UNICODE).build().run();
        String encText = FileAccess.getInputFromFile(fileOutput);
        new CryptBuilder.Builder().data(encText).key("10").outFile(fileOutput).typeAlgorithm(TypeAlgorithm.UNICODE).typeCrypt(TypeCrypt.DECRYPT).build().run();
        assertEquals(message, FileAccess.getInputFromFile(fileOutput));
    }
}
