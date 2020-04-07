package filedifferentator;

import java.util.Arrays;

public class ExtVeryfier {

    static String PATH = "";

    void verify(String filepath){

        PATH = filepath;
        FileReader fileReader = new FileReader();
        fileReader.openFile();

        if(FileReader.flag == 1) {
            if (fileReader.getExtension().equals("TXT")) {
                System.out.println("File Differentiator: Cannot verify TXT file with calculated signature (HEX) " + encodeHexString(fileReader.getSignature()));
            } else if (Arrays.asList(ExtDatabase.get(fileReader.getExtension())).contains(encodeHexString(fileReader.getSignature()))) {
                System.out.println("File Differentiator: It's a *." + fileReader.getExtension() + " file");
            } else {
                System.out.println("File Differentiator: Extension is *." + fileReader.getExtension() + " while actually inside it is not");
            }
        }
        FileReader.flag = 0;
    }

    /**
     *
     * conversion code from https://www.baeldung.com/java-byte-arrays-hex-strings
     * Changed Buffer to Builder
     */
    public String encodeHexString(byte[] byteArray) {
        StringBuilder hexStringBuilder = new StringBuilder();
        for (int i = 0; i < byteArray.length; i++) {
            hexStringBuilder.append(byteToHex(byteArray[i]));
        }
        return hexStringBuilder.toString().toUpperCase();
    }

    public String byteToHex(byte num) {
        char[] hexDigits = new char[2];
        hexDigits[0] = Character.forDigit((num >> 4) & 0xF, 16);
        hexDigits[1] = Character.forDigit((num & 0xF), 16);
        return new String(hexDigits);
    }

}
