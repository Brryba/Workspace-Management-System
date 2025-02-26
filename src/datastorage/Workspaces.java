package datastorage;

import services.workspaces.Workspace;

import java.util.ArrayList;

public class Workspaces extends ArrayList<Workspace> {
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.size(); i++) {
            sb.append(i + 1).append(") ").append(this.get(i).toString());
        }
        return sb.toString();
    }
}
