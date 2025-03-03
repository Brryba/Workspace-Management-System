import UI.menus.AbstractMenu;
import UI.menus.MainMenu;

public class Main {
    public static void main(String[] args) {
        AbstractMenu menu = new MainMenu();
        menu.apply();
    }
}
