package services.reservations;

import UI.interfaces.Applyable;
import data_storage.MainStorage;
import data_storage.Reservations;

public class ReservationCustomerViewer implements Applyable {
    private final String customerName;
    public ReservationCustomerViewer(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public void apply() {
        Reservations reservationsList = MainStorage.reservations;
        int count = 1;
        for (Reservation reservation : reservationsList) {
            if (reservation.getCustomerName() == customerName) {
                System.out.println(count++ + ") " + reservation);
            }
        }
    }

    @Override
    public String getMethodName() {
        return "View my reservations";
    }
}
