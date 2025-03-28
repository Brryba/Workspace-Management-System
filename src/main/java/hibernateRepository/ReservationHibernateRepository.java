package hibernateRepository;

import data_storage.Reservations;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.hibernate.HibernateException;
import services.reservations.Reservation;

import java.util.List;
import java.util.Optional;

public class ReservationHibernateRepository {
    private static final ReservationHibernateRepository instance =
            new ReservationHibernateRepository();
    private final EntityManager entityManager;
    private ReservationHibernateRepository() {
        this.entityManager = HibernateUtil.getEntityManager();
    }

    public static ReservationHibernateRepository getInstance() {
        return instance;
    }

    public void insertReservation(Reservation reservation) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(reservation);
            this.entityManager.getTransaction().commit();
        } catch (HibernateException e) {
            this.entityManager.getTransaction().rollback();
            System.err.println(e.getMessage());
        }
    }

    public Optional<Reservation> getReservation(int reservationID) {
        return Optional.ofNullable(this.entityManager.find(Reservation.class, reservationID));
    }

    public Optional<Reservations> getReservations() {
        Query query = entityManager.createQuery("FROM Reservation");
        List<Reservation> reservations = query.getResultList();
        return reservations.isEmpty() ? Optional.empty() : Optional.of(new Reservations(reservations));
    }

    public Optional<Reservations> getReservations(String customerName) {
        Query query = entityManager.createQuery("FROM Reservation WHERE customerName = :name");
        query.setParameter("name", customerName);
        List<Reservation> reservations = query.getResultList();
        return reservations.isEmpty() ? Optional.empty() : Optional.of(new Reservations(reservations));
    }

    public void deleteReservation(Reservation reservation) {
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(reservation);
        this.entityManager.getTransaction().commit();
    }
}
