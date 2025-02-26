package UI.menus;

import UI.menu_openers.MainMenuOpener;
import UI.menu_openers.WorkspaceUpdateOpener;
import services.reservations.ReservationsAdminViewer;
import services.workspaces.WorkspaceCreator;
import services.workspaces.WorkspaceRemover;

public class AdminsMethodsMenu extends AbstractMethodsMenu {
    public AdminsMethodsMenu() {
        super();
        this.addMethod(1, new WorkspaceCreator());
        this.addMethod(2, new WorkspaceUpdateOpener());
        this.addMethod(3, new WorkspaceRemover());
        this.addMethod(4, new ReservationsAdminViewer());
        this.addMethod(AbstractMethodsMenu.QUIT_MENU_METHOD, new MainMenuOpener());
    }
}