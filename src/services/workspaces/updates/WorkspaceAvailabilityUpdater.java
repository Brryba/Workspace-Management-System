package services.workspaces.updates;

import UI.interfaces.Applyable;
import data_storage.MainStorage;
import services.workspaces.Workspace;

public class WorkspaceAvailabilityUpdater extends WorkplaceUpdater implements Applyable {
    public WorkspaceAvailabilityUpdater(Workspace workspace) {
        super(workspace);
    }

    @Override
    public void apply() {
        System.out.println("Enter availability status [Y/N]");
        String input = MainStorage.scanner.readString().toUpperCase();
        this.workspace.setAvailable((input.equals("Y")));
    }

    @Override
    public String getMethodName() {
        return "Update Availability";
    }
}
