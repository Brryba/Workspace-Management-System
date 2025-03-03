package UI.utilities;

import data_storage.MainStorage;

import java.util.Scanner;

public class ConsoleScanner {
    private final Scanner scanner = new Scanner(System.in);

    public int readInt() {
        int input;
        while (true) {
            try {
                input = Integer.parseInt(scanner.nextLine());
                return input;
            } catch (NumberFormatException exception) {
                System.err.println("Please type a number. Try again:");
            }
        }
    }

    public int readWorkspaceID() {
        System.out.println("Select workspace ID:");
        do {
            int workspaceID = MainStorage.scanner.readInt();
            if (MainStorage.workspaces.containsWorkspace(workspaceID)) {
                return workspaceID;
            } else {
                System.err.println("No such workspace! Try again:");
            }
        } while (true);
    }

    public String readString() {
        return scanner.nextLine();
    }

    public double readDouble() {
        double input;
        while (true) {
            try {
                input = Double.parseDouble(scanner.nextLine());
                return input;
            } catch (NumberFormatException exception) {
                System.err.println("Please type a number. Try again:");
            }
        }
    }
}
