package UI.menu_openers;

import UI.menus.WorkspaceUpdateMenu;
import UI.interfaces.Applyable;
import data_storage.MainStorage;
import services.workspaces.Workspace;

public class WorkspaceUpdateOpener implements Applyable {
    @Override
    public void apply() {
        MainStorage.reservations.toStringAdmin();
        System.out.println("Select workspace ID:");
        System.out.print(MainStorage.workspaces.toString());
        Workspace workspace = MainStorage.workspaces.
                getWorkspaceByID(MainStorage.scanner.readInt());
        WorkspaceUpdateMenu menu = new WorkspaceUpdateMenu(workspace);
        menu.showMenu();
    }

    @Override
    public String getMethodName() {
        return "Change workspace data";
    }
}
