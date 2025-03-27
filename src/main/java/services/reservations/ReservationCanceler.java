package services.reservations;

import JDBCRepository.ReservationRepository;
import UI.interfaces.Applyable;
import UI.utilities.ConsoleScanner;
import hibernateRepository.WorkspaceHibernateRepository;
import services.workspaces.Workspace;

public class ReservationCanceler implements Applyable {
    private final String customerName;
    private final ReservationRepository reservationRepository = ReservationRepository.getInstance();
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

        if (reservationRepository.containsReservation(reservationID)) {
            int workspaceID = reservationRepository.getWorkspaceIDByReservation(reservationID);
            reservationRepository.deleteReservation(reservationID);
            Workspace workspace = workspaceRepository.getWorkspace(workspaceID);
            workspace.setAvailable(true);
            workspaceRepository.persistWorkspace(workspace);
        } else {
            System.err.println("No such reservation!");
        }
    }

    @Override
    public String getMethodName() {
        return "Cancel a reservation";
    }
}