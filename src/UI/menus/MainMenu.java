package UI.menus;

import UI.interfaces.Applyable;
import file_utils.WorkspacesFileSaver;

public class MainMenu extends AbstractMenu implements Applyable {
    @Override
    protected void setMethods() {
        this.addMethod(1, new AdminMenu());
        this.addMethod(2, new CustomerMenu());
        this.addMethod(AbstractMenu.QUIT_MENU_METHOD, new Quit());
    }
    @Override
    public String getMethodName() {
        return "To previous page";
    }
}

class Quit implements Applyable {
    @Override
    public void apply() {
        WorkspacesFileSaver.save(System.getProperty("user.dir") + "/workspaces.txt");
    }

    @Override
    public String getMethodName() {
        return "Quit";
    }
}
