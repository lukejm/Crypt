package Crypt;

public class UnicodeCrypt extends Crypt {

    private final char[] input;
    private String output = "";

    private final int key;

    private UnicodeCrypt(String input, int key) {
        this.input = input.toCharArray();
        this.key = key;
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

        for (char el : input) {
            if (typeCrypt.equals(TypeCrypt.ENCRYPT)) {
                sb.append(shiftUp(el));
            } else if (typeCrypt.equals(TypeCrypt.DECRYPT)) {
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