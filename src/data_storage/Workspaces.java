package data_storage;

import services.workspaces.Workspace;

import java.io.Serializable;
import java.util.ArrayList;

public class Workspaces extends ArrayList<Workspace> implements Serializable {
    public Workspace getWorkspaceByID(int workspaceID) {
        for (Workspace workspace : this) {
            if (workspace.getID() == workspaceID) {
                return workspace;
            }
        }
        return null;
    }

    public boolean containsWorkspace(int workspaceID) {
        for (Workspace workspace : this) {
            if (workspace.getID() == workspaceID) {
                return true;
            }
        }
        return false;
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
