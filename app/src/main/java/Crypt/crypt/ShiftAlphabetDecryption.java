package Crypt.crypt;

public class ShiftAlphabetDecryption {

    private final char[] input;
    private String output = "";

    private final int shift;

    public ShiftAlphabetDecryption(String input, int shift) {
        this.input = input.toCharArray();
        this.shift = shift;
    }

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
                    sb.append(shiftLeft(input[i], 'a', 'z'));
                } else {
                    sb.append(shiftLeft(input[i], 'A', 'Z'));
                }
            } else {
                sb.append(input[i]);
            }
        }
        output = sb.toString();
    }

    private char shiftLeft(char el, char low, char high) {
        if (el - shift < low) {
            return (char) (high - low  + el - shift + 1);
        } else {
            return (char) (el - shift);
        }
    }
}
