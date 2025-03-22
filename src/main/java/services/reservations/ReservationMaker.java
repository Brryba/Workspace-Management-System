package services.reservations;

import UI.interfaces.Applyable;
import data_storage.MainStorage;
import data_storage.Reservations;
import data_storage.Workspaces;
import services.workspaces.AvailableSpacesViewer;
import services.workspaces.Workspace;

import java.time.DateTimeException;

public class ReservationMaker implements Applyable {
    private final String customer;
    public ReservationMaker(String customer) {
        this.customer = customer;
    }

    private void setReservationDateTime(Reservation reservation) throws DateTimeException {
        System.out.println("Enter reservation start date in dd-mm-yyyy format:");
        String startDate = MainStorage.scanner.readString();

        System.out.println("Enter reservation start time in hh:mm:ss format");
        String startTime = MainStorage.scanner.readString();
        reservation.setStart(startDate, startTime);

        System.out.println("Enter reservation end date in dd-mm-yyyy format:");
        String endDate = MainStorage.scanner.readString();

        System.out.println("Enter reservation end time in hh:mm:ss format");
        String endTime = MainStorage.scanner.readString();
        reservation.setEnd(endDate, endTime);
    }

    @Override
    public void apply() {
        Reservations reservationsList = MainStorage.reservations;
        Workspaces workspacesList = MainStorage.workspaces;

        new AvailableSpacesViewer().apply();

        Workspace workspace = workspacesList.getWorkspaceByID(MainStorage.scanner.readWorkspaceID());
        Reservation reservation = new Reservation(this.customer,
                workspace);


        try {
            setReservationDateTime(reservation);
            reservationsList.add(reservation);
            workspace.setAvailable(false);
        } catch (DateTimeException e) {
            System.err.println("Wrong date-time input! Reservation was not done!");
            workspace.setAvailable(true);
        }
    }


    @Override
    public String getMethodName() {
        return "Make a reservation";
    }
}
