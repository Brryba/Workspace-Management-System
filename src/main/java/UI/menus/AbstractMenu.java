package UI.menus;

import UI.interfaces.Applyable;
import data_storage.MainStorage;

import java.util.LinkedHashMap;

public abstract class AbstractMenu
        implements UI.interfaces.MethodsMenu, Applyable {
    public static final int QUIT_MENU_METHOD = 0;
    protected final LinkedHashMap<Integer, Applyable> map = new LinkedHashMap<>();
    protected abstract void setMethods();

    @Override
    public void apply() {
        this.setMethods();
        this.showMenu();
    }

    private void printAllMethods() {
        for (int key : map.keySet()) {
            System.out.println(key + " - " + map.get(key).getMethodName());
        }
    }

    private int selectMethod() {
        System.out.println("Enter your option here:");
        int methodID;
        do {
            methodID = MainStorage.scanner.readInt();
            if (!this.map.containsKey(methodID)) {
                System.err.println("No such option. Try again:");
            }
        } while (!this.map.containsKey(methodID));
        return methodID;
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