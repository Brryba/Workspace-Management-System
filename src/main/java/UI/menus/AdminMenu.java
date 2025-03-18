package UI.menus;

import UI.interfaces.Applyable;
import services.reservations.ReservationsAdminViewer;
import services.workspaces.WorkspaceCreator;
import services.workspaces.WorkspaceRemover;

public class AdminMenu extends AbstractMenu implements Applyable {
    @Override
    protected void setMethods() {
        this.addMethod(1, new WorkspaceCreator());
        this.addMethod(2, new WorkspaceUpdateMenu());
        this.addMethod(3, new WorkspaceRemover());
        this.addMethod(4, new ReservationsAdminViewer());
        this.addMethod(AbstractMenu.QUIT_MENU_METHOD, new MainMenu());
    }

    @Override
    public String getMethodName() {
        return "Admin login";
    }
}