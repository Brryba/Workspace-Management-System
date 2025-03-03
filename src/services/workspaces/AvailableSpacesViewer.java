package services.workspaces;

import UI.interfaces.Applyable;
import data_storage.MainStorage;
import data_storage.Workspaces;

public class AvailableSpacesViewer implements Applyable {
    @Override
    public void apply() {
        Workspaces workspacesList = MainStorage.workspaces;
        for (Workspace workspace : workspacesList) {
            if (workspace.isAvailable()) {
                System.out.println(workspace);
            }
        }
    }

    @Override
    public String getMethodName() {
        return "Browse available spaces";
    }
}
