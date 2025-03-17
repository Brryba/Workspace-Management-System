package services.workspaces;

import UI.interfaces.Applyable;
import data_storage.MainStorage;
import data_storage.Workspaces;

public class AvailableSpacesViewer implements Applyable {
    @Override
    public void apply() {
        Workspaces workspacesList = MainStorage.workspaces;
        workspacesList.stream()
                .filter(Workspace::isAvailable)
                .forEach(System.out::println);
    }

    @Override
    public String getMethodName() {
        return "Browse available spaces";
    }
}
