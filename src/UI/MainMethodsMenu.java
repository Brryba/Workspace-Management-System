package UI;

import UI.interfaces.Callable;

public class MainMethodsMenu extends AbstractMethodsMenu {
    public MainMethodsMenu() {
        super();
        this.put(1, new AdminOpener());
        this.put(2, new CustomerOpener());
        this.put(0, new Quit());
    }
}

class AdminOpener implements Callable {
    @Override
    public void call() {
        System.out.println("Admin");
    }

    @Override
    public String toString() {
        return "Admin login";
    }
}

class CustomerOpener implements Callable {
    @Override
    public void call() {
        System.out.println("Customer");
    }

    @Override
    public String toString() {
        return "Customer login";
    }
}

class Quit implements Callable {
    @Override
    public void call() {
        System.out.println("Quit");
    }

    @Override
    public String toString() {
        return "Quit";
    }
}
