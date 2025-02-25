package UI;

import UI.interfaces.Callable;
import users.Customer;

public class CustomerMethodsMenu extends AbstractMethodsMenu{
    public CustomerMethodsMenu() {
        super();
        this.put(1, new AvailableSpacesBrowser());
        this.put(2, new ReservationMaker());
        this.put(3, new CustomerReservationViewer());
        this.put(4, new ReservationCanceler());
        this.put(0, new Quit());
    }
}

class AvailableSpacesBrowser implements Callable {
    @Override
    public void call() {
        System.out.println("Add space");
    }

    @Override
    public String toString() {
        return "Browse available spaces";
    }
}

class ReservationMaker implements Callable {
    @Override
    public void call() {
        System.out.println("Remove space");
    }

    @Override
    public String toString() {
        return "Make a reservation";
    }
}

class CustomerReservationViewer implements Callable {
    @Override
    public void call() {
        System.out.println("Add space");
    }

    @Override
    public String toString() {
        return "View my reservations";
    }
}

class ReservationCanceler implements Callable {
    @Override
    public void call() {
        System.out.println("Add space");
    }

    @Override
    public String toString() {
        return "Cancel a reservation";
    }
}