package Crypt;

public class UnicodeCrypt {

    private TypeCrypt typeCrypt;
    private char[] input;
    private int key;

    protected UnicodeCrypt(String input, String key, TypeCrypt typeCrypt) {
        this.input = input.toCharArray();
        this.key = Integer.parseInt(key);
        this.typeCrypt = typeCrypt;
    }

    public String getOutput() {
        return process();
    }

    private String process() {
        StringBuilder sb = new StringBuilder();

        for (char el : input) {
            if (typeCrypt.equals(TypeCrypt.ENCRYPT)) {
                sb.append(shiftUp(el));
            } else if (typeCrypt.equals(TypeCrypt.DECRYPT)) {
                sb.append(shiftDown(el));
            }
        }
        return sb.toString();
    }

    private char shiftUp(char el) {
        return (char) (el + key);
    }

    private char shiftDown(char el) {
        return (char) (el - key);
    }
}