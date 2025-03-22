package repository;

import data_storage.Workspaces;
import services.workspaces.Workspace;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WorkspaceRepository {
    private static WorkspaceRepository instance = new WorkspaceRepository();

    private final Connection connection;

    public static WorkspaceRepository getInstance() {
        return instance;
    }

    private WorkspaceRepository() {
        this.connection = DataBaseConnector.getInstance().getConnection();
    }

    public int assignWorkspace() throws SQLException {
        String query = "INSERT INTO workspace () VALUES ()";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeUpdate();
        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        return resultSet.getInt("ID");
    }

    public Workspaces getAllWorkspaces() {
        String query = "SELECT * FROM workspace";
        ResultSet resultSet;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeQuery();
            resultSet = preparedStatement.getResultSet();
            Workspaces workspaces = new Workspaces();
            while (resultSet.next()) {
                Workspace workspace = new Workspace();
                workspace.setID(resultSet.getInt("ID"));
                workspace.setType(resultSet.getString("Type"));
                workspace.setPrice(resultSet.getBigDecimal("Price"));
                workspace.setAvailable(resultSet.getBoolean("IsAvailable"));
                workspaces.add(workspace);
            }
            return workspaces;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public void updateType(int id, String newType) {
        try {
            String query = "UPDATE workspace SET Type = ? WHERE ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, newType);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void updatePrice(int id, double newPrice) {
        BigDecimal decimalPrice = new BigDecimal(newPrice).setScale(2, RoundingMode.HALF_DOWN);
        try {
            String query = "UPDATE workspace SET price = ? WHERE ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, decimalPrice.toString());
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void updateAvailable(int id, boolean isAvailable) {
        try {
            String query = "UPDATE workspace SET IsAvailable = ? WHERE ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setBoolean(1, isAvailable);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void removeWorkspace(int ID)  {
        try {
            String query = "DELETE FROM workspace WHERE ID = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, String.valueOf(ID));
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public boolean containsID(int ID)  {
        String query = "SELECT * FROM workspace WHERE ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, ID);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}
