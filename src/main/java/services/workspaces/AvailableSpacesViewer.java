package services.workspaces;

import UI.interfaces.Applyable;
import data_storage.Workspaces;
import hibernateRepository.WorkspaceHibernateRepository;

public class AvailableSpacesViewer implements Applyable {
    private final WorkspaceHibernateRepository repository
            = WorkspaceHibernateRepository.getInstance();

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
