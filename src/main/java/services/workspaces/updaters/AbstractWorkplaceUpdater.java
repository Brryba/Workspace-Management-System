package services.workspaces.updaters;

import UI.interfaces.Applyable;
import UI.utilities.ConsoleScanner;
import hibernateRepository.WorkspaceHibernateRepository;
import services.workspaces.Workspace;

public abstract class AbstractWorkplaceUpdater implements Applyable {
    protected final Workspace workspace;
    protected final WorkspaceHibernateRepository workspaceRepository =
            WorkspaceHibernateRepository.getInstance();
    protected final ConsoleScanner consoleScanner = ConsoleScanner.getInstance();
    public AbstractWorkplaceUpdater(Workspace workspace) {
        this.workspace = workspace;
    }
}
