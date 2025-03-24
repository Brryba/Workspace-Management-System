package services.reservations;

import UI.interfaces.Applyable;
import UI.utilities.ConsoleScanner;
import repository.ReservationRepository;
import repository.WorkspaceRepository;

public class ReservationCanceler implements Applyable {
    private final String customerName;
    private final ReservationRepository reservationRepository = ReservationRepository.getInstance();
    public ReservationCanceler(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public void apply() {
        System.out.println("Your reservations:");
        new ReservationCustomerViewer(customerName).apply();
        System.out.println("Enter ID:");
        int reservationID = ConsoleScanner.getInstance().readInt();

        if (reservationRepository.containsReservation(reservationID)) {
            int workspaceID = reservationRepository.getWorkspaceIDByReservation(reservationID);
            reservationRepository.deleteReservation(reservationID);
            WorkspaceRepository.getInstance().updateAvailable(workspaceID, true);
        } else {
            System.err.println("No such reservation!");
        }
    }

    @Override
    public String getMethodName() {
        return "Cancel a reservation";
    }
}