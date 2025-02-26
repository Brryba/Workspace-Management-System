package services.reservations;

import UI.interfaces.Applyable;
import data_storage.MainStorage;
import data_storage.Reservations;
import data_storage.Workspaces;
import services.customer.Customer;
import services.workspaces.AvailableSpacesViewer;

public class ReservationMaker implements Applyable {
    private final Customer customer;
    public ReservationMaker(Customer customer) {
        this.customer = customer;
    }

    private void setReservationDateTime(Reservation reservation) {
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
        System.out.println("Enter workspace ID from the list:");

        Reservation reservation = new Reservation(this.customer,
                workspacesList.getWorkspaceByID(MainStorage.scanner.readInt()));


        setReservationDateTime(reservation);
        reservationsList.add(reservation);
    }


    @Override
    public String getMethodName() {
        return "Make a reservation";
    }
}
