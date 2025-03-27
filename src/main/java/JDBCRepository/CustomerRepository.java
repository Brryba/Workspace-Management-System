package JDBCRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRepository {
    private static final CustomerRepository instance = new CustomerRepository(DataBaseConnector.getInstance());

    private final Connection connection;

    private CustomerRepository(DataBaseConnector dataBaseConnector) {
        connection = dataBaseConnector.getConnection();
    }

    public static CustomerRepository getInstance() {
        return instance;
    }

    public void insertCustomer(String name) throws SQLException {
        String query = "INSERT INTO customer VALUES (?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);){
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
        }
    }

    public boolean hasCustomer(String name) throws SQLException {
        String query = "SELECT * FROM customer WHERE name = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);){
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        }
    }
}