package services.workspaces;

import UI.interfaces.Applyable;
import UI.utilities.ConsoleScanner;
import hibernateRepository.WorkspaceHibernateRepository;

import java.util.List;

public class WorkspaceRemover implements Applyable {
    private final WorkspaceHibernateRepository repository = WorkspaceHibernateRepository.getInstance();

    @Override
    public void apply() {
        List<Workspace> all = repository.getAllWorkspaces();
        System.out.println(all.toString());

        repository.removeWorkspace(ConsoleScanner.getInstance().readWorkspaceID());
    }

    @Override
    public String getMethodName() {
        return "Remove a coworking space";
    }
}
