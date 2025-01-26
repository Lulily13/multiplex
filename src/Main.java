import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("User", "Userowicz", "user.userowicz@user.com");

        Cinema cinema1 = new Cinema("Super Kino", "ul.Ugorek 14");

        CinemaRoom room1 = new CinemaRoom(1, false,false);
        room1.addSeats("A1", "A2", "B1", "B2");

        Movie movie1 = new Movie("Star Wars", 150, "STANDARD", "J.J. Abrams");

        Screening screening1 = new Screening(LocalDateTime.of(2025, 1, 26, 17, 25), movie1, room1);
        Screening screening2 = new Screening(LocalDateTime.of(2025, 1, 27, 17, 25), movie1, room1);
        Screening screening3 = new Screening(LocalDateTime.of(2025, 2, 26, 17, 25), movie1, room1);
        Screening screening4 = new Screening(LocalDateTime.of(2025, 2, 27, 17, 25), movie1, room1);

        room1.addScreening(screening1);
        room1.addScreening(screening2);
        room1.addScreening(screening3);
        room1.addScreening(screening4);


        CinemaRoom room2 = new CinemaRoom(2, false,true);
        room1.addSeats("A1", "A2", "A3", "B1", "B2", "B3", "C1", "C2", "C3");

        Movie movie2 = new Movie("Star Trek", 140, "3D", "J.J. Abrams");

        Screening screening5 = new Screening(LocalDateTime.of(2025, 1, 26, 17, 25), movie2, room2);
        Screening screening6 = new Screening(LocalDateTime.of(2025, 1, 27, 17, 25), movie2, room2);
        Screening screening7 = new Screening(LocalDateTime.of(2025, 2, 26, 17, 25), movie2, room2);
        Screening screening8 = new Screening(LocalDateTime.of(2025, 2, 27, 17, 25), movie2, room2);

        room1.addScreening(screening5);
        room1.addScreening(screening6);
        room1.addScreening(screening7);
        room1.addScreening(screening8);


        cinema1.addRoom(room1);
        cinema1.addRoom(room2);

        //=====================

        List<Screening> nextWeekScreenings = cinema1.getNextWeekProgramme();

        System.out.println(nextWeekScreenings);

        screening1.reserveSeats("A1", "A2");
        screening1.buyTickets(user1,"B1");

        System.out.println(screening1.seats);

        screening2.buyTickets("B2");
        screening2.reserveSeats(user1, "A1", "A2");

        System.out.println(screening2.seats);

        List<Reservation> reservations = user1.getReservations();
        System.out.println(reservations);

        List<Ticket> tickets = user1.tickets;
        System.out.println(tickets);
    }
}