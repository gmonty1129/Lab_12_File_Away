import java.util.Scanner;

public class SafeInput {
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = "";
        do {
            System.out.print(prompt + ": ");
            retString = pipe.nextLine().trim();
        } while (retString.length() == 0);
        return retString;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int value = 0;
        boolean isValid = false;

        do {
            System.out.print(prompt + " [" + low + "-" + high + "]: ");
            if (pipe.hasNextInt()) {
                value = pipe.nextInt();
                if (value >= low && value <= high) {
                    isValid = true;
                } else {
                    System.out.println("Input out of range.");
                }
            } else {
                System.out.println("Invalid input.");
            }
            pipe.nextLine(); // clear buffer
        } while (!isValid);

        return value;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String response;
        do {
            System.out.print(prompt + " [Y/N]: ");
            response = pipe.nextLine().trim().toLowerCase();
        } while (!response.equals("y") && !response.equals("n"));
        return response.equals("y");
    }
}
