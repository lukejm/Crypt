/**
 *
 * Luke James Mitton
 * luke.j.mitton@gmail.com
 * https://github.com/lukejm
 *
 */
package Crypt;

public abstract class CryptBuilder {

    public abstract void run();

    public static class Builder {
        private TypeAlgorithm typeAlgorithm = TypeAlgorithm.SHIFT;
        private TypeCrypt typeCrypt = TypeCrypt.ENCRYPT;
        private TypeOutput typeOutput = TypeOutput.CONSOLE;
        private TypeInput typeInput = TypeInput.ARG;

        private String data = "";
        private String inFile = "";
        private String outFile = "";
        private String key = "";

        public Builder typeAlgorithm(TypeAlgorithm typeAlgorithm) {
            this.typeAlgorithm = typeAlgorithm;
            return this;
        }

        public Builder typeCrypt(TypeCrypt typeCrypt) {
            this.typeCrypt = typeCrypt;
            return this;
        }

        public Builder typeOutput(TypeOutput typeOutput) {
            this.typeOutput = typeOutput;
            return this;
        }

        public Builder typeInput(TypeInput typeInput) {
            this.typeInput = typeInput;
            return this;
        }

        public Builder data(String data) {
            this.data = data;
            return this;
        }

        public Builder inFile(String inFile) {
            this.inFile = inFile;
            return this;
        }

        public Builder outFile(String outFile) {
            this.outFile = outFile;
            this.typeOutput = TypeOutput.FILE;
            return this;
        }

        public Builder key(String key) {
            this.key = key;
            return this;
        }

        public TypeAlgorithm getTypeAlgorithm() {
            return typeAlgorithm;
        }

        public TypeCrypt getTypeCrypt() {
            return typeCrypt;
        }

        public TypeOutput getTypeOutput() {
            return typeOutput;
        }

        public TypeInput getTypeInput() {
            return typeInput;
        }

        public String getData() {
            return data;
        }

        public String getInFile() {
            return inFile;
        }

        public String getOutFile() {
            return outFile;
        }

        public String getKey() {
            return key;
        }

        public CryptBuilder build() {
            return new ProcessCrypt(this);
        }
    }
}
