package JDBCRepository;

import data_storage.Reservations;
import services.reservations.Reservation;

import java.sql.*;
import java.util.Optional;

public class ReservationRepository {
    private static final ReservationRepository instance = new ReservationRepository();
    private final Connection connection;
    private ReservationRepository() {
        this.connection = DataBaseConnector.getInstance().getConnection();
    }

    public static ReservationRepository getInstance() {
        return instance;
    }

    public void createReservation(Reservation reservation) {
        String query = "INSERT INTO reservation (workspace_id, customer_name, start, end)" +
                " VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, reservation.getWorkspaceID());
            statement.setString(2, reservation.getCustomerName());
            statement.setTimestamp(3, Timestamp.valueOf(reservation.getStart()));
            statement.setTimestamp(4, Timestamp.valueOf(reservation.getEnd()));
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    private Reservations parseReservations(ResultSet resultSet) throws SQLException {
        Reservations reservations = new Reservations();
        while (resultSet.next()) {
            Reservation reservation = new Reservation(resultSet.getString("customer_name"),
                    resultSet.getInt("workspace_id"),
                    resultSet.getString("type"));
            reservation.setReservationID(resultSet.getInt("id"));
            reservation.setStart(resultSet.getTimestamp("start"));
            reservation.setEnd(resultSet.getTimestamp("end"));
            reservations.add(reservation);
        }
        return reservations;
    }

    public Optional<Reservations> getAllReservations() {
        String query = "SELECT * FROM reservation JOIN workspace " +
                "on workspace_id = workspace.ID";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            return Optional.of(parseReservations(resultSet));
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return Optional.empty();
        }
    }

    public Optional<Reservations> getCustomerReservations(String customerName) {
        String query = "SELECT * FROM reservation JOIN workspace ON" +
                " workspace_id = workspace.ID WHERE customer_name=?";
        try (PreparedStatement statement = connection.prepareStatement(query);){
            statement.setString(1, customerName);
            ResultSet resultSet = statement.executeQuery();
            return Optional.of(parseReservations(resultSet));
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return Optional.empty();
        }
    }

    public boolean containsReservation(int reservationID) {
        String query = "SELECT * FROM reservation WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(query);){
            statement.setInt(1, reservationID);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public void deleteReservation(int reservationID) {
        String query = "DELETE FROM reservation WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(query);){
            statement.setInt(1, reservationID);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public int getWorkspaceIDByReservation(int reservationID) {
        String query = "SELECT workspace_id FROM reservation WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(query);){
            statement.setInt(1, reservationID);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getInt("workspace_id");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return 0;
        }
    }
}
