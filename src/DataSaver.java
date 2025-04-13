import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSaver {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> records = new ArrayList<>();
        int idCounter = 1;

        System.out.println("=== CSV Data Entry ===");

        do {
            String firstName = SafeInput.getNonZeroLenString(in, "Enter First Name");
            String lastName = SafeInput.getNonZeroLenString(in, "Enter Last Name");

            // Format ID with leading zeroes, e.g., 000001
            String id = String.format("%06d", idCounter);

            String email = SafeInput.getNonZeroLenString(in, "Enter Email");
            int yearOfBirth = SafeInput.getRangedInt(in, "Enter Year of Birth", 1900, 2025);

            // Create CSV record
            String record = String.format("%s, %s, %s, %s, %d", firstName, lastName, id, email, yearOfBirth);
            records.add(record);
            idCounter++;

        } while (SafeInput.getYNConfirm(in, "Add another record?"));

        // Get filename and write data to file
        String fileName = SafeInput.getNonZeroLenString(in, "Enter file name (no extension)");
        fileName = "src/" + fileName + ".csv";

        try (FileWriter writer = new FileWriter(new File(fileName))) {
            for (String record : records) {
                writer.write(record + "\n");
            }
            System.out.println("Records saved to: " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }

        in.close();
    }
}


