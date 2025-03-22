package services.workspaces;

import UI.interfaces.Applyable;
import repository.WorkspaceRepository;
import services.workspaces.updaters.WorkspaceAvailabilityUpdater;
import services.workspaces.updaters.WorkspacePriceUpdater;
import services.workspaces.updaters.WorkspaceTypeUpdater;

import java.sql.SQLException;

public class WorkspaceCreator implements Applyable {
    private final WorkspaceRepository repository = WorkspaceRepository.getInstance();

    private void assignWorkspace() {
        int workspaceID = 0;
        try {
            workspaceID = repository.assignWorkspace();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        new WorkspaceTypeUpdater(workspaceID).apply();
        new WorkspacePriceUpdater(workspaceID).apply();
        new WorkspaceAvailabilityUpdater(workspaceID).apply();
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
