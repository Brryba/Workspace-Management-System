package services.workspaces.updates;

import UI.interfaces.Applyable;
import services.workspaces.Workspace;

public abstract class WorkplaceUpdater implements Applyable {
    protected final Workspace workspace;
    public WorkplaceUpdater(Workspace workspace) {
        this.workspace = workspace;
    }
}
