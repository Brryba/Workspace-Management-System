package services.reservations;

import JDBCRepository.WorkspaceRepository;
import UI.interfaces.Applyable;
import UI.utilities.ConsoleScanner;
import hibernateRepository.ReservationHibernateRepository;
import hibernateRepository.WorkspaceHibernateRepository;
import services.workspaces.AvailableSpacesViewer;
import services.workspaces.Workspace;

import java.time.DateTimeException;

public class ReservationMaker implements Applyable {
    private final String customer;
    private final ReservationHibernateRepository reservationRepository;
    private final WorkspaceHibernateRepository workspaceRepository;
    private final ConsoleScanner scanner;
    public ReservationMaker(String customer) {
        this.customer = customer;
        reservationRepository = ReservationHibernateRepository.getInstance();
        workspaceRepository = WorkspaceHibernateRepository.getInstance();
        scanner = ConsoleScanner.getInstance();
    }

    private void setReservationDateTime(Reservation reservation) throws DateTimeException {
        System.out.println("Enter reservation start date in dd-mm-yyyy format:");
        String startDate = scanner.readString();

        System.out.println("Enter reservation start time in hh:mm:ss format");
        String startTime = scanner.readString();
        reservation.setStart(startDate, startTime);

        System.out.println("Enter reservation end date in dd-mm-yyyy format:");
        String endDate = scanner.readString();

        System.out.println("Enter reservation end time in hh:mm:ss format");
        String endTime = scanner.readString();
        reservation.setEnd(endDate, endTime);
    }

    @Override
    public void apply() {

        new AvailableSpacesViewer().apply();

        int workspaceID = scanner.readWorkspaceID();
        Reservation reservation = new Reservation(this.customer,
                workspaceID, WorkspaceRepository.getInstance().getWorkspaceName(workspaceID));

        try {
            setReservationDateTime(reservation);
            reservationRepository.insertReservation(reservation);
            Workspace workspace = workspaceRepository.getWorkspace(workspaceID);
            workspace.setAvailable(false);
            workspaceRepository.persistWorkspace(workspace);
        } catch (DateTimeException e) {
            System.err.println("Wrong date-time input! Reservation was not done!");
        }
    }


    @Override
    public String getMethodName() {
        return "Make a reservation";
    }
}
