package file_utils;

public class WorkspacesNotFoundException extends Exception {
    public WorkspacesNotFoundException() {
        super("Unable to read workspaces information!");
    }
}
