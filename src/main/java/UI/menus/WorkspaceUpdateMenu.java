package UI.menus;

import UI.interfaces.Applyable;
import UI.interfaces.MethodsMenu;
import data_storage.MainStorage;
import services.workspaces.Workspace;
import services.workspaces.updaters.WorkspaceAvailabilityUpdater;
import services.workspaces.updaters.WorkspaceIDUpdater;
import services.workspaces.updaters.WorkspacePriceUpdater;
import services.workspaces.updaters.WorkspaceTypeUpdater;

public class WorkspaceUpdateMenu extends AbstractMenu implements Applyable, MethodsMenu {
    @Override
    protected void setMethods() {
        Workspace workspace = MainStorage.workspaces.
                getWorkspaceByID(MainStorage.scanner.readWorkspaceID());
        this.addMethod(1, new WorkspaceIDUpdater(workspace));
        this.addMethod(2, new WorkspaceTypeUpdater(workspace));
        this.addMethod(3, new WorkspacePriceUpdater(workspace));
        this.addMethod(4, new WorkspaceAvailabilityUpdater(workspace));
        this.addMethod(AbstractMenu.QUIT_MENU_METHOD, new MainMenu());
    }

    @Override
    public String getMethodName() {
        return "Change workspace data";
    }
}
