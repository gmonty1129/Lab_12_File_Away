import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class FileInspector {

    public static void main(String[] args) {
        // Set the default directory to src folder of the project
        JFileChooser fileChooser = new JFileChooser("src");

        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;

            System.out.println("Contents of the file:\n");

            try (Scanner scanner = new Scanner(selectedFile)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                    lineCount++;

                    // Count words using regex to split on whitespace
                    String[] words = line.trim().split("\\s+");
                    if (!line.trim().isEmpty()) {
                        wordCount += words.length;
                    }

                    // Count characters in line (including spaces)
                    charCount += line.length();
                }

                // Summary Report
                System.out.println("\n--- Summary Report ---");
                System.out.println("File Name: " + selectedFile.getName());
                System.out.println("Number of Lines: " + lineCount);
                System.out.println("Number of Words: " + wordCount);
                System.out.println("Number of Characters: " + charCount);

            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + e.getMessage());
            }

        } else {
            System.out.println("File selection canceled.");
        }
    }
}
