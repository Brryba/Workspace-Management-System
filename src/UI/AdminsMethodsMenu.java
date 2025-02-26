package UI;

import services.reservations.ReservationsAdminViewer;
import services.workspaces.WorkspaceAdder;
import services.workspaces.WorkspaceRemover;

public class AdminsMethodsMenu extends AbstractMethodsMenu {
    public AdminsMethodsMenu() {
        super();
        this.addMethod(1, new WorkspaceAdder());
        this.addMethod(2, new WorkspaceRemover());
        this.addMethod(3, new ReservationsAdminViewer());
        this.addMethod(AbstractMethodsMenu.QUIT_MENU_METHOD, new MainMenuOpener());
    }
}