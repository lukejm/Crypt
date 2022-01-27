package Crypt;

public class ProcessCrypt extends CryptBuilder {

    private TypeAlgorithm typeAlgorithm = TypeAlgorithm.SHIFT;
    private TypeCrypt typeCrypt = TypeCrypt.ENCRYPT;
    private TypeOutput typeOutput = TypeOutput.CONSOLE;
    private TypeInput typeInput = TypeInput.ARG;
    private String data = "";
    private String inFile = "";
    private String outFile = "";
    private String key = "";

    protected ProcessCrypt(Builder builder) {
        this.typeAlgorithm = builder.getTypeAlgorithm();
        this.typeCrypt = builder.getTypeCrypt();
        this.typeOutput = builder.getTypeOutput();
        this.typeInput = builder.getTypeInput();
        this.data = builder.getData();
        this.inFile = builder.getInFile();
        this.outFile = builder.getOutFile();
        this.key = builder.getKey();
    }

    @Override
    public void run() {
        setInput();
        runInput();
    }

    private void setInput() {
        if (typeInput.equals(TypeInput.FILE)) {
            data = FileAccess.getInputFromFile(inFile);
        }
    }

    private void runInput() {
        String output = "";
        if (typeAlgorithm.equals(TypeAlgorithm.UNICODE)) {
            output = new UnicodeCrypt(data, key, typeCrypt).getOutput();
        } else if (typeAlgorithm.equals(TypeAlgorithm.SHIFT)) {
            output = new ShiftCrypt(data, key, typeCrypt).getOutput();
        }
        saveOutput(output);
    }

    private void saveOutput(String output) {
        if (typeOutput.equals(TypeOutput.FILE)) {
            FileAccess.setOutputToFile(output, outFile);
        } else {
            System.out.println(output);
        }
    }
}
