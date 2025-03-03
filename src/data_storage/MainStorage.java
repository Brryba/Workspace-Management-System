package data_storage;

import UI.utilities.ConsoleScanner;

public abstract class MainStorage {
    public static ConsoleScanner scanner = new ConsoleScanner();
    public static Customers customers = new Customers();
    public static Reservations reservations = new Reservations();
    public static Workspaces workspaces = new Workspaces();
}
