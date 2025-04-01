package services.workspaces.updaters;

import UI.interfaces.Applyable;
import services.workspaces.Workspace;

public class WorkspacePriceUpdater extends AbstractWorkplaceUpdater implements Applyable {
    public WorkspacePriceUpdater(Workspace workspace) {
        super(workspace);
    }

    @Override
    public void apply() {
        System.out.println("Enter workspace price:");
        this.workspace.setPrice(consoleScanner.readDouble());
        this.workspaceRepository.persistWorkspace(workspace);
    }

    @Override
    public String getMethodName() {
        return "Update price";
    }
}
