package UI;

import UI.interfaces.Applyable;
import services.workspaces.AvailableSpacesViewer;

public class CustomerMethodsMenu extends UI.AbstractMethodsMenu {
    public CustomerMethodsMenu() {
        super();
        this.addMethod(1, new AvailableSpacesViewer());
        this.addMethod(2, new ReservationMaker());
        this.addMethod(3, new CustomerReservationViewer());
        this.addMethod(4, new ReservationCanceler());
        this.addMethod(AbstractMethodsMenu.QUIT_MENU_METHOD, new MainMenuOpener());
    }
}

class ReservationMaker implements Applyable {
    @Override
    public void apply() {
        System.out.println("Remove space");
    }

    @Override
    public String getMethodName() {
        return "Make a reservation";
    }
}

class CustomerReservationViewer implements Applyable {
    @Override
    public void apply() {
        System.out.println("Add space");
    }

    @Override
    public String getMethodName() {
        return "View my services.reservations";
    }
}

class ReservationCanceler implements Applyable {
    @Override
    public void apply() {
        System.out.println("Add space");
    }

    @Override
    public String getMethodName() {
        return "Cancel a reservation";
    }
}