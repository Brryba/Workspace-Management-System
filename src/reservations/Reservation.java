package reservations;

import users.User;
import workplaces.Workplace;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Reservation {
    private User user;
    private Workplace workplace;
    private LocalDateTime start;
    private LocalDateTime end;
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public Reservation(User user, Workplace workplace) {
        this.user = user;
        this.workplace = workplace;
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

    @Override
    public String toString() {
        return "Workplace ID: " + this.workplace.getID() +
                "\nStart Time:" + start.format(dateTimeFormatter) +
                "\nEnd Time:" + end.format(dateTimeFormatter);
    }

    public String toStringAdmin() {
        return "User ID:" + 0 +
                "\n" + this.toString();
    }
}
