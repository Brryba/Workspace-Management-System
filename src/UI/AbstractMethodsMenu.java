package UI;

import UI.interfaces.Applyable;
import datastorage.MainStorage;

import java.util.LinkedHashMap;

public abstract class AbstractMethodsMenu
        implements UI.interfaces.MethodsMenu {
    public static final int QUIT_MENU_METHOD = 0;
    protected final LinkedHashMap<Integer, Applyable> map = new LinkedHashMap<>();
    private void printAllMethods() {
        for (int key : map.keySet()) {
            System.out.println(key + " - " + map.get(key).getMethodName());
        }
    }

    private int selectMethod() {
        System.out.println("Enter your option here:");
        return Integer.parseInt(MainStorage.scanner.nextLine());
    }

    public void addMethod(int methodID, Applyable method) {
        this.map.put(methodID, method);
    }

    @Override
    public void showMenu() {
        int methodID;
        do {
            printAllMethods();
            methodID = selectMethod();
            map.get(methodID).apply();
        } while (methodID != QUIT_MENU_METHOD);
    }
}