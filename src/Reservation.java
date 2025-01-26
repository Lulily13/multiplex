import java.util.ArrayList;
import java.util.List;

public class Reservation extends SeatAssignment {
    String reservationID;

    public Reservation(String reservationID, Screening screening, Seat seat, User user) {
        super(screening, seat, user);
        this.reservationID = reservationID;
    }
}
