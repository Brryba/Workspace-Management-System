package UI;

import UI.interfaces.Callable;

public class AdminsMethodsMenu extends AbstractMethodsMenu{
    public AdminsMethodsMenu() {
        super();
        this.put(1, new AvailableSpacesBrowser());
        this.put(2, new ReservationMaker());
        this.put(3, new AllReservationViewer());
        this.put(0, new Quit());
    }
}

class SpaceAdder implements Callable {
    @Override
    public void call() {
        System.out.println("Add space");
    }

    @Override
    public String toString() {
        return "Add a new coworking space";
    }
}

class SpaceRemover implements Callable {
    @Override
    public void call() {
        System.out.println("Remove space");
    }

    @Override
    public String toString() {
        return "Remove a coworking space";
    }
}

class AllReservationViewer implements Callable {
    @Override
    public void call() {
        System.out.println("Add space");
    }

    @Override
    public String toString() {
        return "View all reservations";
    }
}