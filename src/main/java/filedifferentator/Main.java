package filedifferentator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ExtVeryfier extensionVeryficator = new ExtVeryfier();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=========================== File Differentator ===========================");
        System.out.println("== /TIF,GIF,JPG,TXT,CLASS,AVI,MOV,ZIP,TAR,PDF,PNG,PSD,MIDI,WAV,WEBM,MKV/ ==");
        System.out.println("Enter absolute PATH to the file:");
        extensionVeryficator.verify(scanner.nextLine());

    }

}
