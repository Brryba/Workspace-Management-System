package services.reservations;

import UI.interfaces.Applyable;
import UI.utilities.ConsoleScanner;
import hibernateRepository.ReservationHibernateRepository;
import hibernateRepository.WorkspaceHibernateRepository;
import services.workspaces.Workspace;

public class ReservationCanceler implements Applyable {
    private final String customerName;
    private final ReservationHibernateRepository reservationRepository =
            ReservationHibernateRepository.getInstance();
    private final WorkspaceHibernateRepository workspaceRepository =
            WorkspaceHibernateRepository.getInstance();

    public ReservationCanceler(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public void apply() {
        System.out.println("Your reservations:");
        new ReservationCustomerViewer(customerName).apply();
        System.out.println("Enter ID:");
        int reservationID = ConsoleScanner.getInstance().readInt();

        reservationRepository.getReservation(reservationID).ifPresentOrElse(
                (reservation) -> {
            int workspaceID = reservation.getWorkspaceID();
            reservationRepository.deleteReservation(reservation);
            Workspace workspace = workspaceRepository.getWorkspace(workspaceID);
            workspace.setAvailable(true);
            workspaceRepository.persistWorkspace(workspace);
        }, () ->
                System.err.println("No such reservation!")
        );
    }

    @Override
    public String getMethodName() {
        return "Cancel a reservation";
    }
}