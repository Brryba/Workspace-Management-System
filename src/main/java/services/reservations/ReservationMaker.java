package services.reservations;

import UI.interfaces.Applyable;
import UI.utilities.ConsoleScanner;
import repository.ReservationRepository;
import repository.WorkspaceRepository;
import services.workspaces.AvailableSpacesViewer;

import java.time.DateTimeException;

public class ReservationMaker implements Applyable {
    private final String customer;
    private final ReservationRepository reservationRepository;
    private final WorkspaceRepository workspaceRepository;
    private final ConsoleScanner scanner;
    public ReservationMaker(String customer) {
        this.customer = customer;
        reservationRepository = ReservationRepository.getInstance();
        workspaceRepository = WorkspaceRepository.getInstance();
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
            reservationRepository.createReservation(reservation);
            workspaceRepository.updateAvailable(workspaceID, false);
        } catch (DateTimeException e) {
            System.err.println("Wrong date-time input! Reservation was not done!");
        }
    }


    @Override
    public String getMethodName() {
        return "Make a reservation";
    }
}
