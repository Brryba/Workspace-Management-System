package UI.menu_openers;

import UI.menus.AdminsMethodsMenu;
import UI.interfaces.Applyable;

public class AdminMenuOpener implements Applyable {
    @Override
    public void apply() {
        AdminsMethodsMenu menu = new AdminsMethodsMenu();
        menu.showMenu();
    }

    @Override
    public String getMethodName() {
        return "Admin login";
    }
}