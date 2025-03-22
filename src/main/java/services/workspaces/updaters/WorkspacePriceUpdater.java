package services.workspaces.updaters;

import UI.interfaces.Applyable;
import data_storage.MainStorage;

public class WorkspacePriceUpdater extends AbstractWorkplaceUpdater implements Applyable {
    public WorkspacePriceUpdater(int workspaceID) {
        super(workspaceID);
    }

    @Override
    public void apply() {
        System.out.println("Enter workspace price:");
        this.workspaceRepository.updatePrice(this.workspaceID, MainStorage.scanner.readDouble());
    }

    @Override
    public String getMethodName() {
        return "Update price";
    }
}
