import UI.menus.AbstractMenu;
import UI.menus.MainMenu;
import data_storage.MainStorage;
import data_storage.Workspaces;
import file_utils.WorkspacesFileOpener;
import file_utils.WorkspacesNotFoundException;

public class Main {
    private static final String DEFAULT_FILE_NAME = "/workspaces.ws";
    private static void initializeWorkspaces() {
        try {
            MainStorage.workspaces = WorkspacesFileOpener.open(System.getProperty("user.dir") + DEFAULT_FILE_NAME);
        } catch (WorkspacesNotFoundException e) {
            MainStorage.workspaces = new Workspaces();
        }
    }

    public static void main(String[] args) {
        initializeWorkspaces();
        AbstractMenu menu = new MainMenu();
        menu.apply();
    }
}
