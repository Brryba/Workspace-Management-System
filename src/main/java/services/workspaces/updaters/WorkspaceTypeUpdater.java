package services.workspaces.updaters;

import UI.interfaces.Applyable;
import services.workspaces.Workspace;

public class WorkspaceTypeUpdater extends AbstractWorkplaceUpdater implements Applyable {
    public WorkspaceTypeUpdater(Workspace workspace) {
        super(workspace);
    }

    @Override
    public void apply() {
        System.out.println("Enter workspace type:");
        workspace.setType(consoleScanner.readString());
        workspaceRepository.persistWorkspace(workspace);
    }

    @Override
    public String getMethodName() {
        return "Update workspace type";
    }
}
