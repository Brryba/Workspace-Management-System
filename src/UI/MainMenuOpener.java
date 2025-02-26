package UI;

import UI.interfaces.Applyable;

public class MainMenuOpener implements Applyable {
    @Override
    public void apply() {
        System.out.println("0");
    }

    @Override
    public String getMethodName() {
        return "To main menu";
    }
}
