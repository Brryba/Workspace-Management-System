package services.workspaces.updaters;

import UI.interfaces.Applyable;
import data_storage.MainStorage;

public class WorkspaceAvailabilityUpdater extends AbstractWorkplaceUpdater implements Applyable {
    public WorkspaceAvailabilityUpdater(int workspaceID) {
        super(workspaceID);
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
        workspaceRepository.updateAvailable(this.workspaceID, input.equals("Y"));
    }

    @Override
    public String getMethodName() {
        return "Update Availability";
    }
}
