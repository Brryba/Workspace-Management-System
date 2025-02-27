package services.workspaces.updaters;

import UI.interfaces.Applyable;
import data_storage.MainStorage;
import services.workspaces.Workspace;

public class WorkspaceAvailabilityUpdater extends AbstractWorkplaceUpdater implements Applyable {
    public WorkspaceAvailabilityUpdater(Workspace workspace) {
        super(workspace);
    }

    @Override
    public void apply() {
        System.out.println("Enter availability status [Y/N]");
        String input;
        do {
            input = MainStorage.scanner.readString().toUpperCase();
            if (!input.equals("Y") && !input.equals("N")) {
                System.err.println("Select Y or N");
            }
        } while (!input.equals("Y") && !input.equals("N"));
        this.workspace.setAvailable((input.equals("Y")));
    }

    @Override
    public String getMethodName() {
        return "Update Availability";
    }
}
