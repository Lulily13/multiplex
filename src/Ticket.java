public class Ticket extends SeatAssignment {
    String tickedID;

    public Ticket(String tickedID, Screening screening, Seat seat, User user) {
        super(screening, seat, user);
        this.tickedID = tickedID;
    }
}
