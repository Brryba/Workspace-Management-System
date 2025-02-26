package services.workspaces.updates;

import UI.interfaces.Applyable;
import data_storage.MainStorage;
import services.workspaces.Workspace;

public class WorkspaceTypeUpdater extends WorkplaceUpdater implements Applyable {
    public WorkspaceTypeUpdater(Workspace workspace) {
        super(workspace);
    }

    @Override
    public void apply() {
        System.out.println("Enter workspace type:");
        this.workspace.setType(MainStorage.scanner.readString());
    }

    @Override
    public String getMethodName() {
        return "Update workspace type";
    }
}
