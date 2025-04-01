package UI.menus;

import UI.interfaces.Applyable;
import UI.interfaces.MethodsMenu;
import UI.utilities.ConsoleScanner;
import hibernateRepository.WorkspaceHibernateRepository;
import services.workspaces.Workspace;
import services.workspaces.updaters.WorkspaceAvailabilityUpdater;
import services.workspaces.updaters.WorkspacePriceUpdater;
import services.workspaces.updaters.WorkspaceTypeUpdater;

public class WorkspaceUpdateMenu extends AbstractMenu implements Applyable, MethodsMenu {
    @Override
    protected void setMethods() {
        System.out.println(WorkspaceHibernateRepository.getInstance().getAllWorkspaces().toString());
        int workspaceID = ConsoleScanner.getInstance().readWorkspaceID();
        Workspace workspace = WorkspaceHibernateRepository.getInstance().getWorkspace(workspaceID);
        this.addMethod(1, new WorkspaceTypeUpdater(workspace));
        this.addMethod(2, new WorkspacePriceUpdater(workspace));
        this.addMethod(3, new WorkspaceAvailabilityUpdater(workspace));
        this.addMethod(AbstractMenu.QUIT_MENU_METHOD, new MainMenu());
    }

    @Override
    public String getMethodName() {
        return "Change workspace data";
    }
}
