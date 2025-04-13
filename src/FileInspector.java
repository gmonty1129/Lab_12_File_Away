import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileInspector {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {

        }


        JFileChooser fileChooser = new JFileChooser("src");

        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;

            System.out.println("\n--- File Content ---");

            try (Scanner scanner = new Scanner(selectedFile)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                    lineCount++;


                    if (!line.trim().isEmpty()) {
                        String[] words = line.trim().split("\\s+");
                        wordCount += words.length;
                    }
                    charCount += line.length();
                }


                System.out.println("\n--- Summary Report ---");
                System.out.println("File Name: " + selectedFile.getName());
                System.out.println("Number of Lines: " + lineCount);
                System.out.println("Number of Words: " + wordCount);
                System.out.println("Number of Characters: " + charCount);

            } catch (FileNotFoundException e) {
                System.out.println("Error: File not found.");
            }

        } else {
            System.out.println("No file selected.");
        }
    }
}
