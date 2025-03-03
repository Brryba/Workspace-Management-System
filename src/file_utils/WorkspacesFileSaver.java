package file_utils;

import data_storage.MainStorage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public abstract class WorkspacesFileSaver {
    public static void save(String path) {
        try (ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(path))) {
            ous.writeObject(MainStorage.workspaces);
        } catch (IOException e) {
            System.err.println("Error! Workspaces were not saved");
        }
    }
}
