package datastorage;

import reservations.Reservation;

import java.util.ArrayList;

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
}
