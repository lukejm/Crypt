package Crypt;

import java.util.List;

public class CommandLine {
    private static final String UNICODE_MODE_ARG = "unicode";
    private static final String SHIFT_MODE_ARG = "shift";
    private static final String ENCRYPT_MODE_ARG = "enc";
    private static final String DECRYPT_MODE_ARG = "dec";

    private static CryptBuilder cryptBuilder;

    private static TypeAlgorithm typeAlgorithm = TypeAlgorithm.SHIFT;
    private static TypeCrypt typeCrypt = TypeCrypt.ENCRYPT;
    private static TypeOutput typeOutput = TypeOutput.CONSOLE;
    private static TypeInput typeInput = TypeInput.ARG;
    private static String data = "";
    private static String key = "";
    private static String inFile = "";
    private static String outFile = "";

    public static void run(String[] args) {
        processArgs(args);
        buildCrypt();
        runCrypt();
    }

    private static void processArgs(String[] args) {
        List<String> argsList = List.of(args);

        if (argsList.contains("-data")) {
            data = argsList.get(argsList.indexOf("-data") + 1);
        }

        if (argsList.contains("-key")) {
            key = argsList.get(argsList.indexOf("-key") + 1);
        }

        if (argsList.contains("-in")) {
            inFile = argsList.get(argsList.indexOf("-in") + 1);
            typeInput = TypeInput.FILE;
        } else {
            typeInput = TypeInput.ARG;
        }

        if (argsList.contains("-out")) {
            outFile = argsList.get(argsList.indexOf("-out") + 1);
            typeOutput = TypeOutput.FILE;
        } else {
            typeOutput = TypeOutput.CONSOLE;
        }

        if (argsList.contains("-alg")) {
            String mode = argsList.get(argsList.indexOf("-alg") + 1);
            if (mode.equals(UNICODE_MODE_ARG)) {
                typeAlgorithm = TypeAlgorithm.UNICODE;
            } else if (mode.equals(SHIFT_MODE_ARG)) {
                typeAlgorithm = TypeAlgorithm.SHIFT;
            }
        }

        if (argsList.contains("-mode")) {
            String mode = argsList.get(argsList.indexOf("-mode") + 1);
            if (mode.equals(ENCRYPT_MODE_ARG)) {
                typeCrypt = TypeCrypt.ENCRYPT;
            } else if (mode.equals(DECRYPT_MODE_ARG)) {
                typeCrypt = TypeCrypt.DECRYPT;
            }
        }
    }

    private static void buildCrypt() {
        cryptBuilder =  new CryptBuilder.Builder()
                .typeAlgorithm(typeAlgorithm)
                .typeCrypt(typeCrypt)
                .typeOutput(typeOutput)
                .typeInput(typeInput)
                .data(data)
                .inFile(inFile)
                .outFile(outFile)
                .key(key)
                .build();
    }

    private static void runCrypt() {
        cryptBuilder.run();
    }
}
