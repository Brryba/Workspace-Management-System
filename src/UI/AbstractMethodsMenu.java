package UI;

import UI.interfaces.Callable;
import UI.interfaces.MethodsMenu;

import java.util.LinkedHashMap;
import java.util.Scanner;

public abstract class AbstractMethodsMenu extends LinkedHashMap<Integer, Callable>
        implements UI.interfaces.MethodsMenu {
    @Override
    public void printAllMethods() {
        for (int key : this.keySet()) {
            System.out.println(key + " - " + this.get(key).toString());
        }
    }

    @Override
    public void selectMethod() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your option here:");
        int methodID = scanner.nextInt();
        scanner.close();
        this.get(methodID).call();
    }
}