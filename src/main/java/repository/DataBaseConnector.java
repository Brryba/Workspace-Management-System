package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnector {
    private static final DataBaseConnector instance = new DataBaseConnector();

    private final String URL = "jdbc:mysql://localhost:3306/workspacemanagement";
    private final String USER = "root";
    private final String PASS = System.getenv("DB_PASSWORD");
    private Connection connection;

    public static DataBaseConnector getInstance() {
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    private DataBaseConnector() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            System.err.println("Error loading the database\n" + e.getMessage());
        }
    }
}
