package services.reservations;

import UI.interfaces.Applyable;
import data_storage.MainStorage;

public class ReservationsAdminViewer implements Applyable {
    @Override
    public void apply() {
        System.out.println(MainStorage.reservations.toStringAdmin());
    }

    @Override
    public String getMethodName() {
        return "View all reservations";
    }
}