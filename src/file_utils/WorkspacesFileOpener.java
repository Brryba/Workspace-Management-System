package file_utils;

import data_storage.Workspaces;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class WorkspacesFileOpener {
    public static Workspaces open(String path) throws WorkspacesNotFoundException {
        Workspaces workspaces;
        try (ObjectInputStream ous = new ObjectInputStream(new FileInputStream(path))) {
            workspaces = (Workspaces) ous.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new WorkspacesNotFoundException();
        }
        return workspaces;
    }
}
