package data_storage;

import UI.utilities.ConsoleScanner;

public abstract class MainStorage {
    public static ConsoleScanner scanner = new ConsoleScanner();
    public static Reservations reservations = new Reservations();
}
