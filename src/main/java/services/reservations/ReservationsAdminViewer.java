package services.reservations;

import UI.interfaces.Applyable;
import repository.ReservationRepository;

public class ReservationsAdminViewer implements Applyable {
    private final ReservationRepository reservationRepository;

    public ReservationsAdminViewer() {
        this.reservationRepository = ReservationRepository.getInstance();
    }

    @Override
    public void apply() {
        reservationRepository.getAllReservations()
                .ifPresentOrElse(System.out::println, () -> {
            System.out.println("No Reservations Found");
        });
    }

    @Override
    public String getMethodName() {
        return "View all reservations";
    }
}