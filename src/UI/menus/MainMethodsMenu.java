package UI.menus;

import UI.interfaces.Applyable;
import UI.menu_openers.AdminMenuOpener;
import UI.menu_openers.CustomerMenuOpener;

public class MainMethodsMenu extends AbstractMethodsMenu {
    public MainMethodsMenu() {
        super();
        this.addMethod(1, new AdminMenuOpener());
        this.addMethod(2, new CustomerMenuOpener());
        this.addMethod(AbstractMethodsMenu.QUIT_MENU_METHOD, new Quit());
    }
}

class Quit implements Applyable {
    @Override
    public void apply() {
        System.out.println("Quit");
    }

    @Override
    public String getMethodName() {
        return "Quit";
    }
}
