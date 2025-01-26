import java.util.ArrayList;
import java.util.List;

public class CinemaRoom {
    int number;
    boolean isVIP;
    boolean supports3D;
    List<Seat> seats;
    List<Screening> screenings;

    public CinemaRoom(int number, boolean isVIP, boolean supports3D) {
        this.number = number;
        this.isVIP = isVIP;
        this.supports3D = supports3D;
        this.seats = new ArrayList<>();
        this.screenings = new ArrayList<>();
    }

    public void addSeats(String... seats) {
        for (String seat : seats) {
            this.seats.add(new Seat(seat));
        }
    }

    public void addScreening(Screening screening) {
        this.screenings.add(screening);
    }
}
