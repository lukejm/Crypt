package Crypt.crypt;

public class UnicodeCrypt extends Crypt {

    private final char[] input;
    private String output = "";

    private final int key;

    private UnicodeCrypt(String input, int key) {
        this.input = input.toCharArray();
        this.key = key;
    }

    @Override
    public String getOutput(CryptType cryptType) {
        if (output.equals("")) {
            process(cryptType);
        }
        return output;
    }

    private void process(CryptType cryptType) {
        StringBuilder sb = new StringBuilder();

        for (char el : input) {
            if (cryptType.equals(CryptType.ENCRYPT)) {
                sb.append(shiftUp(el));
            } else if (cryptType.equals(CryptType.DECRYPT)) {
                sb.append(shiftDown(el));
            }
        }
        output = sb.toString();
    }

    private char shiftUp(char el) {
        return (char) (el + key);
    }

    private char shiftDown(char el) {
        return (char) (el - key);
    }

    public static class Builder {
        private String input = "";
        private int key = 0;

        public Builder input(String input) {
            this.input = input;
            return this;
        }

        public Builder key(int key) {
            this.key = key;
            return this;
        }

        public Crypt build() {
            return new UnicodeCrypt(input, key);
        }
    }
}