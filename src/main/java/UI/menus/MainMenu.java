package UI.menus;

import UI.interfaces.Applyable;
import hibernateRepository.HibernateUtil;

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
        HibernateUtil.close();
    }

    @Override
    public String getMethodName() {
        return "Quit";
    }
}
