package Crypt;

import java.util.List;

public class ConsoleInput {

    private static Crypt crypt;
    private static TypeAlgorithm typeAlgorithm = TypeAlgorithm.SHIFT;
    private static TypeCrypt typeCrypt = TypeCrypt.ENCRYPT;
    private static TypeOutput typeOutput = TypeOutput.CONSOLE;
    private static TypeInput typeInput = TypeInput.ARG;

    private static String data = "";
    private static String inFile = "";
    private static String outFile = "";
    private static String input = "";

    private static int key = 0;

    public static void runApp(String[] args) {
        processArgs(args);
        setInput();
        setupCrypt();
        if (typeCrypt.equals(TypeCrypt.ENCRYPT)) {
            encrypt();
        } else if (typeCrypt.equals(TypeCrypt.DECRYPT)) {
            decrypt();
        }
    }

    private static void processArgs(String[] args) {

        List<String> argsList = List.of(args);

        if (argsList.contains("-mode")) {
            String modeArg = argsList.get(argsList.indexOf("-mode") + 1);
            if (modeArg.equals("enc")) {
                typeCrypt = TypeCrypt.ENCRYPT;

            } else if (modeArg.equals("dec")) {
                typeCrypt = TypeCrypt.DECRYPT;
            }
        }
        if (argsList.contains("-alg")) {
            String algArg = argsList.get(argsList.indexOf("-alg") + 1);
            if (algArg.equals("shift")) {
                typeAlgorithm = TypeAlgorithm.SHIFT;
            } else if (algArg.equals("unicode")) {
                typeAlgorithm = TypeAlgorithm.UNICODE;
            }
        }
        if (argsList.contains("-key")) {
            key = Integer.parseInt(argsList.get(argsList.indexOf("-key") + 1));
        }
        if (argsList.contains("-data")) {
            data = argsList.get(argsList.indexOf("-data") + 1);
            typeInput = TypeInput.ARG;
        }
        if (argsList.contains("-in") && !argsList.contains("-data")) {
            inFile = argsList.get(argsList.indexOf("-in") + 1);
            typeInput = TypeInput.FILE;
        }
        if (argsList.contains("-out")) {
            outFile = argsList.get(argsList.indexOf("-out") + 1);
            typeOutput = TypeOutput.FILE;
        }
    }

    private static void setInput() {
        if (typeInput.equals(TypeInput.FILE)) {
            input = FileAccess.getInputFromFile(inFile);
        } else if (typeInput.equals(TypeInput.ARG)) {
            input = data;
        }
    }

    private static void setupCrypt() {
        if (typeAlgorithm.equals(TypeAlgorithm.SHIFT)) {
            crypt = new ShiftCrypt.Builder().input(input).shift(key).build();
        } else if (typeAlgorithm.equals(TypeAlgorithm.UNICODE)) {
            crypt = new UnicodeCrypt.Builder().input(input).key(key).build();
        }
    }

    private static void encrypt() {
        String data = crypt.getOutput(TypeCrypt.ENCRYPT);
        outputData(data);
    }

    private static void decrypt() {
        String data = crypt.getOutput(TypeCrypt.DECRYPT);
        outputData(data);
    }

    private static void outputData(String data) {
        if (typeOutput.equals(TypeOutput.FILE)) {
            FileAccess.setOutputToFile(data, outFile);
        } else if (typeOutput.equals(TypeOutput.CONSOLE)) {
            System.out.println(data);
        }
    }
}
