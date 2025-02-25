package UI;

import UI.interfaces.Callable;

import java.util.LinkedHashMap;
import java.util.Scanner;

public abstract class AbstractMethodsMenu extends LinkedHashMap<Integer, Callable>
        implements UI.interfaces.MethodsMenu {
    private Scanner scanner;
    private void printAllMethods() {
        for (int key : this.keySet()) {
            System.out.println(key + " - " + this.get(key).toString());
        }
    }

    private Callable selectMethod() {
        System.out.println("Enter your option here:");
        return this.get(scanner.nextInt());
    }

    @Override
    public void showMenu() {
        scanner = new Scanner(System.in);
        Callable method;

        do {
            printAllMethods();
            method = selectMethod();
            method.call();
        } while (!(method instanceof Quit));
        scanner.close();
    }
}