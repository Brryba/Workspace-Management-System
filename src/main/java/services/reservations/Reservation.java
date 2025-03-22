package services.reservations;

import services.workspaces.Workspace;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Reservation {
    private final String customerName;
    private final Workspace workspace;
    private LocalDateTime start;
    private LocalDateTime end;
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public Reservation(String customerName, Workspace workplace) {
        this.customerName = customerName;
        this.workspace = workplace;
        workplace.setAvailable(false);
    }

    private LocalDateTime parseDateTime(String date, String time) {
        String dateTime = date.trim() + " " + time.trim();
        return LocalDateTime.parse(dateTime, dateTimeFormatter);
    }

    public void setStart(String date, String time) {
        this.start = parseDateTime(date, time);
    }

    public void setEnd(String date, String time) {
        this.end = parseDateTime(date, time);
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public Workspace getWorkspace() {
        return this.workspace;
    }

    @Override
    public String toString() {
        return "Workplace ID: " + this.workspace.getID() +
                "\nStart Time: " + start.format(dateTimeFormatter) +
                "\nEnd Time: " + end.format(dateTimeFormatter);
    }

    public String toStringAdmin() {
        return "Customer Name:" + this.customerName +
                "\n" + this;
    }
}
