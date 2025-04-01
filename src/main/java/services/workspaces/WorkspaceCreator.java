package services.workspaces;

import UI.interfaces.Applyable;
import hibernateRepository.WorkspaceHibernateRepository;
import org.hibernate.HibernateException;
import services.workspaces.updaters.WorkspaceAvailabilityUpdater;
import services.workspaces.updaters.WorkspacePriceUpdater;
import services.workspaces.updaters.WorkspaceTypeUpdater;

public class WorkspaceCreator implements Applyable {
    private final WorkspaceHibernateRepository repository =
            WorkspaceHibernateRepository.getInstance();

    private void assignWorkspace() {
        Workspace workspace = new Workspace();
        try {
            repository.persistWorkspace(workspace);
        } catch (HibernateException e) {
            System.err.println(e.getMessage());
            return;
        }

        new WorkspaceTypeUpdater(workspace).apply();
        new WorkspacePriceUpdater(workspace).apply();
        new WorkspaceAvailabilityUpdater(workspace).apply();
    }

    @Override
    public void apply() {
        assignWorkspace();
    }

    @Override
    public String getMethodName() {
        return "Add a new coworking space";
    }
}
