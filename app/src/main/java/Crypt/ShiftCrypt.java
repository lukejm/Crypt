/**
 *
 * Luke James Mitton
 * luke.j.mitton@gmail.com
 * https://github.com/lukejm
 *
 */
package Crypt;

public class ShiftCrypt {

    private TypeCrypt typeCrypt = TypeCrypt.ENCRYPT;
    char[] input;
    private int key;


    protected ShiftCrypt(String input, String key, TypeCrypt typeCrypt) {
        this.input = input.toCharArray();
        this.key = Integer.parseInt(key);
        this.typeCrypt = typeCrypt;
    }

    public String getOutput() {
        return process();
    }

    private String process() {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length; i++) {
            if (Character.isAlphabetic(input[i])) {
                if (Character.isLowerCase(input[i])) {
                    sb.append(shiftDirection(typeCrypt, input[i], 'a', 'z'));
                } else {
                    sb.append(shiftDirection(typeCrypt, input[i], 'A', 'Z'));
                }
            } else {
                sb.append(input[i]);
            }
        }
        return sb.toString();
    }

    private char shiftDirection(TypeCrypt typeCrypt, char el, char low, char high) {
        char curr = ' ';
        if (typeCrypt.equals(TypeCrypt.ENCRYPT)) {
            curr = shiftRight(el, low, high);
        } else if (typeCrypt.equals(TypeCrypt.DECRYPT)) {
            curr = shiftLeft(el, low, high);
        }
        return curr;
    }

    private char shiftRight(char el, char low, char high) {
        if (el + key > high) {
            return (char) (low + el + key - high - 1);
        } else {
            return (char) (el + key);
        }
    }

    private char shiftLeft(char el, char low, char high) {
        if (el - key < low) {
            return (char) (high - low + el - key + 1);
        } else {
            return (char) (el - key);
        }
    }
}
