import java.util.ArrayList;
import java.util.List;

public class User {
    String name;
    String surname;
    String email;
    List<Reservation> reservations; // jedna rezerwacja odpowiada jednemu seatowi
    List<Ticket> tickets;// jeden bilet odpowiada jednemu seatowi

    public User(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.reservations = new ArrayList<>();
        this.tickets = new ArrayList<>();
    }

    public void addReservation(Reservation reservation) {
        this.reservations.add(reservation);
    }

    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }
}
