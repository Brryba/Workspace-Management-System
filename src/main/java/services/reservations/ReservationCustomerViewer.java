package services.reservations;

import JDBCRepository.ReservationRepository;
import UI.interfaces.Applyable;

public class ReservationCustomerViewer implements Applyable {
    private final String customerName;
    private final ReservationRepository reservationRepository =
            ReservationRepository.getInstance();
    public ReservationCustomerViewer(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public void apply() {
        reservationRepository.getCustomerReservations(customerName)
                .ifPresentOrElse((reservations) -> {
            if (reservations.isEmpty()) {
                System.err.println("No reservations found");
                return;
            }
            int count = 1;
            for (Reservation reservation : reservations) {
                if (reservation.getCustomerName().equals(customerName)) {
                    System.out.println(count++ + ") " + reservation);
                }
            }
        }, () -> System.out.println("No reservations found"));
    }

    @Override
    public String getMethodName() {
        return "View my reservations";
    }
}
