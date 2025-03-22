package UI.menus;

import UI.interfaces.Applyable;
import file_utils.WorkspacesFileSaver;
import repository.DataBaseConnector;

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
    private static final String DEFAULT_FILE_NAME = "/workspaces.ws";
    @Override
    public void apply() {
        WorkspacesFileSaver.save(System.getProperty("user.dir") + DEFAULT_FILE_NAME);
        DataBaseConnector.getInstance().closeConnection();
    }

    @Override
    public String getMethodName() {
        return "Quit";
    }
}
