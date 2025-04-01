package services.reservations;

import UI.interfaces.Applyable;
import hibernateRepository.ReservationHibernateRepository;

public class ReservationsAdminViewer implements Applyable {
    private final ReservationHibernateRepository reservationRepository;

    public ReservationsAdminViewer() {
        this.reservationRepository =
                ReservationHibernateRepository.getInstance();
    }

    @Override
    public void apply() {
        reservationRepository.getReservations()
                .ifPresentOrElse((reservations) -> {
                    System.out.println(reservations.toStringAdmin());
                }, () -> System.out.println("No Reservations Found"));
    }

    @Override
    public String getMethodName() {
        return "View all reservations";
    }
}