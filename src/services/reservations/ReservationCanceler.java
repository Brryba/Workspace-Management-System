package services.reservations;

import UI.interfaces.Applyable;
import data_storage.MainStorage;
import data_storage.Reservations;
import services.customer.Customer;

public class ReservationCanceler implements Applyable {
    private final Customer customer;
    public ReservationCanceler(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void apply() {
        Reservations reservationsList = MainStorage.reservations;
        System.out.println("Your reservations:");
        new ReservationCustomerViewer(customer).apply();
        System.out.println("Open reservation number to cancel:");
        Reservation reservation = reservationsList.get(MainStorage.scanner.readInt() - 1);
        reservation.getWorkspace().setAvailable(true);
        reservationsList.remove(reservation);
    }

    @Override
    public String getMethodName() {
        return "Cancel a reservation";
    }
}