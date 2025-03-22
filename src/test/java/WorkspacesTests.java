import data_storage.Workspaces;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import services.workspaces.Workspace;

import static org.junit.jupiter.api.Assertions.*;

class WorkspacesTests {
    private Workspaces workspaces;
    @BeforeEach
    public void beforeEach() {
        workspaces = new Workspaces();
    }

    public Workspace createWorkspace(int ID, String type, double price, boolean isAvailable) {
        Workspace workspace = new Workspace();
        workspace.setID(ID);
        workspace.setType(type);
        workspace.setPrice(price);
        workspace.setAvailable(isAvailable);
        return workspace;
    }

    private void addWorkspaces() {
        workspaces.add(createWorkspace(0, "open", 25, true));
        workspaces.add(createWorkspace(1, "closed", 25, false));
        workspaces.add(createWorkspace(2, "other", 52, true));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testContainsWorkspace_emptyWorkspaceReturnsFalse(int id) {

        boolean containsWorkspace = workspaces.containsWorkspace(id);

        assertFalse(containsWorkspace);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void testContainsWorkspace_checkIfFindsWorkspaceWithCorrectID(int id) {
        addWorkspaces();

        Workspace workspace = workspaces.getWorkspaceByID(id);

        assertNotNull(workspace);
        assertEquals(workspace.getID(), id);
    }

    @Test
    void testContainsWorkspace_checkIfDoesntFindUnexistingID() {
        addWorkspaces();

        Workspace workspace = workspaces.getWorkspaceByID(3);

        assertNull(workspace);
    }
}
