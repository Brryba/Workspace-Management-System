package data_storage;

import services.reservations.Reservation;

import java.util.ArrayList;
import java.util.List;

public class Reservations extends ArrayList<Reservation> {
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.size(); i++) {
            sb.append(i + 1).append(") ").append(this.get(i).toString());
        }
        return sb.toString();
    }

    public String toStringAdmin() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.size(); i++) {
            sb.append(i + 1).append(") ").append(this.get(i).toStringAdmin());
        }
        return sb.toString();
    }

    public Reservations(List<Reservation> reservations) {
        super(reservations);
    }

    public Reservations() {
        super();
    }
}
