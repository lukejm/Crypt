package Crypt.crypt;

public class ShiftCrypt {

    private final char[] input;
    private String output = "";

    private final int shift;

    public ShiftCrypt(String input, int shift) {
        this.input = input.toCharArray();
        this.shift = shift;
    }

    public String getOutput(CryptType cryptType) {
        if (output.equals("")) {
            process(cryptType);
        }
        return output;
    }

    private void process(CryptType cryptType) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length; i++) {
            if (Character.isAlphabetic(input[i])) {
                if (Character.isLowerCase(input[i])) {
                    sb.append(shiftDirection(cryptType, input[i], 'a', 'z'));
                } else {
                    sb.append(shiftDirection(cryptType, input[i], 'A', 'Z'));
                }
            } else {
                sb.append(input[i]);
            }
        }
        output = sb.toString();
    }

    private char shiftDirection(CryptType cryptType, char el, char low, char high) {
        char curr = ' ';
        if (cryptType.equals(CryptType.ENCRYPT)) {
            curr = shiftRight(el, low, high);
        } else if (cryptType.equals(CryptType.DECRYPT)) {
            curr = shiftLeft(el, low, high);
        }
        return curr;
    }

    private char shiftRight(char el, char low, char high) {
        if (el + shift > high) {
            return (char) (low + el + shift - high - 1);
        } else {
            return (char) (el + shift);
        }
    }

    private char shiftLeft(char el, char low, char high) {
        if (el - shift < low) {
            return (char) (high - low + el - shift + 1);
        } else {
            return (char) (el - shift);
        }
    }
}
