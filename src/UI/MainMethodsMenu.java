package UI;

import UI.interfaces.Applyable;

public class MainMethodsMenu extends UI.AbstractMethodsMenu {
    public MainMethodsMenu() {
        super();
        this.addMethod(1, new AdminOpener());
        this.addMethod(2, new CustomerOpener());
        this.addMethod(AbstractMethodsMenu.QUIT_MENU_METHOD, new Quit());
    }
}

class AdminOpener implements Applyable {
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

class CustomerOpener implements Applyable {
    @Override
    public void apply() {
        System.out.println("Customer");
    }

    @Override
    public String getMethodName() {
        return "Customer login";
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
