package services.workspaces.updates;

import UI.interfaces.Applyable;
import data_storage.MainStorage;
import services.workspaces.Workspace;

public class WorkspacePriceUpdater extends WorkplaceUpdater implements Applyable {
    public WorkspacePriceUpdater(Workspace workspace) {
        super(workspace);
    }

    @Override
    public void apply() {
        System.out.println("Enter workspace price:");
        this.workspace.setPrice(MainStorage.scanner.readDouble());
    }

    @Override
    public String getMethodName() {
        return "Update price";
    }
}
