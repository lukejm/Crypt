package Crypt;

public class ShiftCrypt extends Crypt {

    private char[] input;
    private String output = "";

    private int shift;

    private ShiftCrypt(String input, int shift) {
        this.input = input.toCharArray();
        this.shift = shift;
    }

    @Override
    public String getOutput(TypeCrypt typeCrypt) {
        if (output.equals("")) {
            process(typeCrypt);
        }
        return output;
    }

    private void process(TypeCrypt typeCrypt) {

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
        output = sb.toString();
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

    public static class Builder {
        private String input = "";
        private int shift = 0;

        public Builder input(String input) {
            this.input = input;
            return this;
        }

        public Builder shift(int shift) {
            this.shift = shift;
            return this;
        }

        public Crypt build() {
            return new ShiftCrypt(input, shift);
        }
    }
}
