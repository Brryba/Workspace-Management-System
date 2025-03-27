package services.workspaces;

import JDBCRepository.WorkspaceRepository;
import UI.interfaces.Applyable;
import data_storage.Workspaces;

public class AvailableSpacesViewer implements Applyable {
    private final WorkspaceRepository repository = WorkspaceRepository.getInstance();

    @Override
    public void apply() {
        Workspaces workspacesList = repository.getAllWorkspaces();
        workspacesList.stream()
                .filter(Workspace::isAvailable)
                .forEach(System.out::println);
    }

    @Override
    public String getMethodName() {
        return "Browse available spaces";
    }
}
