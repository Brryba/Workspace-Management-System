package services.workspaces;

import UI.interfaces.Applyable;
import data_storage.MainStorage;
import data_storage.Workspaces;
import services.workspaces.updaters.WorkspaceAvailabilityUpdater;
import services.workspaces.updaters.WorkspaceIDUpdater;
import services.workspaces.updaters.WorkspacePriceUpdater;
import services.workspaces.updaters.WorkspaceTypeUpdater;

public class WorkspaceCreator implements Applyable {
    private Workspace assignWorkPlace() {
        Workspace workspace = new Workspace();

        new WorkspaceIDUpdater(workspace).apply();
        new WorkspaceTypeUpdater(workspace).apply();
        new WorkspacePriceUpdater(workspace).apply();
        new WorkspaceAvailabilityUpdater(workspace).apply();

        return workspace;
    }

    @Override
    public void apply() {
        Workspaces workplacesList = MainStorage.workspaces;
        workplacesList.add(assignWorkPlace());
    }

    @Override
    public String getMethodName() {
        return "Add a new coworking space";
    }
}
