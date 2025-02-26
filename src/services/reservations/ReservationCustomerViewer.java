package services.reservations;

import UI.interfaces.Applyable;
import data_storage.MainStorage;
import data_storage.Reservations;
import services.customer.Customer;

public class ReservationCustomerViewer implements Applyable {
    private Customer customer;
    public ReservationCustomerViewer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void apply() {
        Reservations reservationsList = MainStorage.reservations;
        int count = 1;
        for (Reservation reservation : reservationsList) {
            if (reservation.getCustomer() == customer) {
                System.out.println(count++ + ") " + reservation);
            }
        }
    }

    @Override
    public String getMethodName() {
        return "View my reservations";
    }
}
