package datastorage;

import java.util.Scanner;

public abstract class MainStorage {
    public static Scanner scanner = new Scanner(System.in);
    public static Customers customers = new Customers();
    public static Reservations reservations = new Reservations();
    public static Workspaces workspaces = new Workspaces();
}
