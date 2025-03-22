package UI.menus;

import UI.interfaces.Applyable;
import UI.interfaces.MethodsMenu;
import data_storage.MainStorage;
import repository.WorkspaceRepository;
import services.workspaces.updaters.WorkspaceAvailabilityUpdater;
import services.workspaces.updaters.WorkspacePriceUpdater;
import services.workspaces.updaters.WorkspaceTypeUpdater;

public class WorkspaceUpdateMenu extends AbstractMenu implements Applyable, MethodsMenu {
    @Override
    protected void setMethods() {
        System.out.println(WorkspaceRepository.getInstance().getAllWorkspaces().toString());
        int workspaceID = MainStorage.scanner.readWorkspaceID();
        this.addMethod(1, new WorkspaceTypeUpdater(workspaceID));
        this.addMethod(2, new WorkspacePriceUpdater(workspaceID));
        this.addMethod(3, new WorkspaceAvailabilityUpdater(workspaceID));
        this.addMethod(AbstractMenu.QUIT_MENU_METHOD, new MainMenu());
    }

    @Override
    public String getMethodName() {
        return "Change workspace data";
    }
}
