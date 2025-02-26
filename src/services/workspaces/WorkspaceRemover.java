package services.workspaces;

import UI.interfaces.Applyable;
import data_storage.MainStorage;
import data_storage.Workspaces;

public class WorkspaceRemover implements Applyable {
    @Override
    public void apply() {
        Workspaces workplacesList = MainStorage.workspaces;
        System.out.println(workplacesList.toString());
        workplacesList.remove(MainStorage.scanner.readInt() - 1);
    }

    @Override
    public String getMethodName() {
        return "Remove a coworking space";
    }
}
