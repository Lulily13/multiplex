import java.time.LocalDateTime;
import java.util.*;

public class Screening {
    LocalDateTime time;
    Movie movie;
    CinemaRoom room;
    Map<String, Seat> seatIds;
    Map<Seat, SeatAssignment> seats; // id miejsca, przypisanie miejsca

    public Screening(LocalDateTime time, Movie movie, CinemaRoom room) {
        this.time = time;
        this.movie = movie;
        this.room = room;
        this.seatIds = new HashMap<>();
        this.seats = new HashMap<>();

        for (Seat seat : room.seats) {
            this.seatIds.put(seat.id, seat);
            this.seats.put(seat, null);
        }
    }

    public void reserveSeats(String... seatsIds) {
        for (String id : seatsIds) {
            Seat seat = this.seatIds.get(id);
            Reservation reservation = new Reservation(UUID.randomUUID().toString(), this, seat, null);
            this.seats.put(seat, reservation);
        }
    }

    public void reserveSeats(User user, String... seatsIds) {
        for (String id : seatsIds) {
            Seat seat = this.seatIds.get(id);
            Reservation reservation = new Reservation(UUID.randomUUID().toString(), this, seat, user);
            user.addReservation(reservation);
            this.seats.put(seat, reservation);
        }
    }

    public void buyTickets(String... seatsIds) {
        for (String id : seatsIds) {
            Seat seat = this.seatIds.get(id);
            Ticket ticket = new Ticket(UUID.randomUUID().toString(), this, seat, null);
            this.seats.put(seat, ticket);
        }
    }

    public void buyTickets(User user, String... seatsIds) {
        for (String id : seatsIds) {
            Seat seat = this.seatIds.get(id);
            Ticket ticket = new Ticket(UUID.randomUUID().toString(), this, seat, user);
            user.addTicket(ticket);
            this.seats.put(seat, ticket);
        }
    }

    @Override
    public String toString() {
        return "Screening{" +
                "time=" + time +
                ", movie=" + movie.title +
                ", room=" + room.number +
                '}';
    }
}
