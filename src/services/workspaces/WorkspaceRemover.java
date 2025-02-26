package services.workspaces;

import UI.interfaces.Applyable;
import datastorage.MainStorage;
import datastorage.Workspaces;

public class WorkspaceRemover implements Applyable {
    @Override
    public void apply() {
        Workspaces workplacesList = MainStorage.workspaces;
        System.out.println(workplacesList.toString());
        workplacesList.remove(Integer.parseInt(MainStorage.scanner.nextLine()) - 1);
    }

    @Override
    public String getMethodName() {
        return "Remove a coworking space";
    }
}
