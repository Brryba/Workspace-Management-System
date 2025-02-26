package UI.menus;

import UI.menu_openers.MainMenuOpener;
import services.workspaces.Workspace;
import services.workspaces.updates.WorkspaceAvailabilityUpdater;
import services.workspaces.updates.WorkspaceIDUpdater;
import services.workspaces.updates.WorkspacePriceUpdater;
import services.workspaces.updates.WorkspaceTypeUpdater;

public class WorkspaceUpdateMenu extends AbstractMethodsMenu {
    public WorkspaceUpdateMenu(Workspace workspace) {
        super();
        this.addMethod(1, new WorkspaceIDUpdater(workspace));
        this.addMethod(2, new WorkspaceTypeUpdater(workspace));
        this.addMethod(3, new WorkspacePriceUpdater(workspace));
        this.addMethod(4, new WorkspaceAvailabilityUpdater(workspace));
        this.addMethod(AbstractMethodsMenu.QUIT_MENU_METHOD, new MainMenuOpener());
    }
}
