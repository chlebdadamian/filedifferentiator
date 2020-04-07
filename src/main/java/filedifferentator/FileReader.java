package filedifferentator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FileReader {

    private byte[] fileSignature = new byte[4];
    private String filename;
    static int flag = 0;

    void openFile() {

        Path dataPath = FileSystems.getDefault().getPath(ExtVeryfier.PATH);
        this.filename = dataPath.getFileName().toString();

        try (FileInputStream inputFile = new FileInputStream(dataPath.toFile())) {

            // check extension
            checkExtension();
            //read magic numbers
            inputFile.read(fileSignature, 0, 4);
            flag = 1;

        } catch (FileNotFoundException | NullPointerException e) {
            System.out.println("Necessary file is not present or the path is wrong");
        } catch (IOException e) {
            System.out.println("Cannot open selected file");
        } catch (IllegalArgumentException e) {
            System.out.println("File with " + checkFileExtension(filename) + " extension is not handled by this program");
        }

    }

    String getExtension() {
        return checkFileExtension(filename).toUpperCase();
    }

    byte[] getSignature() {
        return fileSignature;
    }

    private String checkFileExtension(String file) {
        int i = file.lastIndexOf('.');
        return i > 0 ? file.substring(i + 1).toUpperCase() : "";
    }

    private void checkExtension() {
        Stream.of(ExtDatabase.values()).filter(e -> e.name().equalsIgnoreCase(checkFileExtension(filename)))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
