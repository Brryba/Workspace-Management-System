package data_storage;

import services.workspaces.Workspace;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Workspaces extends ArrayList<Workspace> implements Serializable {
    public Workspace getWorkspaceByID(int workspaceID) {
        return this.stream()
                .filter(workspace -> workspace.getID() == workspaceID)
                .findAny().orElse(null);
    }

    public boolean containsWorkspace(int workspaceID) {
        return this.stream()
                .anyMatch(workspace -> workspace.getID() == workspaceID);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Workspace workspace : this) {
            sb.append(workspace.toString()).append("\n");
        }
        return sb.toString();
    }

    public Workspaces(List<Workspace> workspaces) {
        super(workspaces);
    }

    public Workspaces() {
        super();
    }
}
