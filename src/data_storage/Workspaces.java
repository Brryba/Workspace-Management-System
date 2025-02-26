package data_storage;

import services.workspaces.Workspace;

import java.util.ArrayList;

public class Workspaces extends ArrayList<Workspace> {
    public Workspace getWorkspaceByID(int workspaceID) {
        for (Workspace workspace : this) {
            if (workspace.getID() == workspaceID) {
                return workspace;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Workspace workspace : this) {
            sb.append(workspace.toString()).append("\n");
        }
        return sb.toString();
    }
}
