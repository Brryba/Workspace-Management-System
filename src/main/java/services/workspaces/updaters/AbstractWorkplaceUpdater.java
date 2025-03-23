package services.workspaces.updaters;

import UI.interfaces.Applyable;
import UI.utilities.ConsoleScanner;
import repository.WorkspaceRepository;

public abstract class AbstractWorkplaceUpdater implements Applyable {
    protected final int workspaceID;
    protected final WorkspaceRepository workspaceRepository = WorkspaceRepository.getInstance();
    protected final ConsoleScanner consoleScanner = ConsoleScanner.getInstance();
    public AbstractWorkplaceUpdater(int workspaceID) {
        this.workspaceID = workspaceID;
    }
}
