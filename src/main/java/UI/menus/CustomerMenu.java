package UI.menus;

import UI.interfaces.Applyable;
import services.customers.CustomerSelector;
import services.reservations.ReservationCanceler;
import services.reservations.ReservationCustomerViewer;
import services.reservations.ReservationMaker;
import services.workspaces.AvailableSpacesViewer;

public class CustomerMenu extends AbstractMenu implements Applyable {
    @Override
    protected void setMethods() {
        String customerName = CustomerSelector.selectCustomer();
        this.addMethod(1, new AvailableSpacesViewer());
        this.addMethod(2, new ReservationMaker(customerName));
        this.addMethod(3, new ReservationCustomerViewer(customerName));
        this.addMethod(4, new ReservationCanceler(customerName));
        this.addMethod(AbstractMenu.QUIT_MENU_METHOD, new MainMenu());
    }

    @Override
    public String getMethodName() {
        return "Customer login";
    }
}