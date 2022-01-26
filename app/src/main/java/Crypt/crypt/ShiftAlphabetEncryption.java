package Crypt.crypt;

public class ShiftAlphabetEncryption extends Decryption {

    private final char[] input;
    private String output = "";

    private final int shift;

    public ShiftAlphabetEncryption(String input, int shift) {
        this.input = input.toCharArray();
        this.shift = shift;
    }

    @Override
    public String getOutput() {
        if (output.equals("")) {    // should always be false,
                                    // extra check for code changes
            process();
        }
        return output;
    }

    private void process() {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length; i++) {
            if (Character.isAlphabetic(input[i])) {
                if (Character.isLowerCase(input[i])) {
                    sb.append(shiftRight(input[i], 'a', 'z'));
                } else {
                    sb.append(shiftRight(input[i], 'A', 'Z'));
                }
            } else {
                sb.append(input[i]);
            }
        }
        output = sb.toString();
    }

    private char shiftRight(char el, char low, char high) {
        if (el + shift > high) {
            return (char) (low + el + shift - high - 1);
        } else {
            return (char) (el + shift);
        }
    }
}
