package services.workspaces.updaters;

import UI.interfaces.Applyable;
import services.workspaces.Workspace;

public abstract class AbstractWorkplaceUpdater implements Applyable {
    protected final Workspace workspace;
    public AbstractWorkplaceUpdater(Workspace workspace) {
        this.workspace = workspace;
    }
}
