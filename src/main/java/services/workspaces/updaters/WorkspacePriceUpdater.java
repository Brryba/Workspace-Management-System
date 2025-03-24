package services.workspaces.updaters;

import UI.interfaces.Applyable;

public class WorkspacePriceUpdater extends AbstractWorkplaceUpdater implements Applyable {
    public WorkspacePriceUpdater(int workspaceID) {
        super(workspaceID);
    }

    @Override
    public void apply() {
        System.out.println("Enter workspace price:");
        this.workspaceRepository.updatePrice(this.workspaceID, consoleScanner.readDouble());
    }

    @Override
    public String getMethodName() {
        return "Update price";
    }
}
