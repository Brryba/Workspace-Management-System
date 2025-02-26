package UI.menus;

import UI.menu_openers.MainMenuOpener;
import services.reservations.ReservationCanceler;
import services.reservations.ReservationCustomerViewer;
import services.reservations.ReservationMaker;
import services.customer.Customer;
import services.workspaces.AvailableSpacesViewer;

public class CustomerMethodsMenu extends AbstractMethodsMenu {
    public Customer customer;

    public CustomerMethodsMenu() {
        super();
        this.addMethod(1, new AvailableSpacesViewer());
        this.addMethod(2, new ReservationMaker(customer));
        this.addMethod(3, new ReservationCustomerViewer(customer));
        this.addMethod(4, new ReservationCanceler(customer));
        this.addMethod(AbstractMethodsMenu.QUIT_MENU_METHOD, new MainMenuOpener());
    }
}