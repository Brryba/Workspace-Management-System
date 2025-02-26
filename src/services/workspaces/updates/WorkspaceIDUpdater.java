package services.workspaces.updates;

import UI.interfaces.Applyable;
import data_storage.MainStorage;
import services.workspaces.Workspace;

public class WorkspaceIDUpdater extends WorkplaceUpdater implements Applyable {
    public WorkspaceIDUpdater(Workspace workspace) {
        super(workspace);
    }

    @Override
    public void apply() {
        System.out.println("Enter workspace ID");
        this.workspace.setID(MainStorage.scanner.readInt());
    }

    @Override
    public String getMethodName() {
        return "Change ID";
    }
}
