package UI.utilities;

import java.util.Scanner;

public class ConsoleScanner {
    private final Scanner scanner = new Scanner(System.in);

    public int readInt() {
        return Integer.parseInt(scanner.nextLine());
    }

    public String readString() {
        return scanner.nextLine();
    }

    public double readDouble() {
        return Double.parseDouble(scanner.nextLine());
    }
}
