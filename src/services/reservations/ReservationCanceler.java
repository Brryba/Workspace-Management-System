package services.reservations;

import UI.interfaces.Applyable;
import data_storage.MainStorage;
import data_storage.Reservations;
import services.customers.Customer;

public class ReservationCanceler implements Applyable {
    private final Customer customer;
    public ReservationCanceler(Customer customer) {
        this.customer = customer;
    }

    private int readReservationNum() {
        System.out.println("Open reservation number to cancel:");
        return MainStorage.scanner.readInt() - 1;
    }

    @Override
    public void apply() {
        Reservations reservationsList = MainStorage.reservations;
        System.out.println("Your reservations:");
        new ReservationCustomerViewer(customer).apply();
        int reservationNum = readReservationNum();

        if (reservationNum >= 0 && reservationNum < reservationsList.size()) {
            Reservation reservation = reservationsList.get(reservationNum);
            reservation.getWorkspace().setAvailable(true);
            reservationsList.remove(reservation);
        } else {
            System.err.println("No such reservation!");
        }
    }

    @Override
    public String getMethodName() {
        return "Cancel a reservation";
    }
}