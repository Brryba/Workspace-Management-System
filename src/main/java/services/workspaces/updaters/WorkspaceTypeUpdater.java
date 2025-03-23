package services.workspaces.updaters;

import UI.interfaces.Applyable;

public class WorkspaceTypeUpdater extends AbstractWorkplaceUpdater implements Applyable {
    public WorkspaceTypeUpdater(int workspaceID) {
        super(workspaceID);
    }

    @Override
    public void apply() {
        System.out.println("Enter workspace type:");
        workspaceRepository.updateType(this.workspaceID, consoleScanner.readString());
    }

    @Override
    public String getMethodName() {
        return "Update workspace type";
    }
}
