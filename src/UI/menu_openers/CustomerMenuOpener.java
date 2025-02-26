package UI.menu_openers;

import UI.menus.CustomerMethodsMenu;
import UI.interfaces.Applyable;
import services.customer.CustomerSelector;

public class CustomerMenuOpener implements Applyable {
    @Override
    public void apply() {
        CustomerMethodsMenu menu = new CustomerMethodsMenu();
        menu.customer = CustomerSelector.selectCustomer();
        menu.showMenu();
    }

    @Override
    public String getMethodName() {
        return "Customer login";
    }
}