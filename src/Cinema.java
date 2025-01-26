import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Cinema {
    String name;
    String location;
    List<CinemaRoom> cinemaRooms;

    public Cinema(String name, String location) {
        this.name = name;
        this.location = location;
        this.cinemaRooms = new ArrayList<>();
    }

    public void addRoom(CinemaRoom room) {
        cinemaRooms.add(room);
    }

    public List<Screening> getNextWeekProgramme() {
        List<Screening> allScreenings = new ArrayList<>();
        for (CinemaRoom room : cinemaRooms) {
            allScreenings.addAll(room.screenings);
        }
        LocalDate nextWeek = LocalDate.now().plusWeeks(1);

        List<Screening> nextWeekScreenings = new ArrayList<>();
        for (Screening screening : allScreenings) {
            LocalDate dayOfScreening = screening.time.toLocalDate();
            if (dayOfScreening.isAfter(LocalDate.now()) && dayOfScreening.isBefore(nextWeek)) {
                nextWeekScreenings.add(screening);
            }
        }
        return nextWeekScreenings;
    }
}