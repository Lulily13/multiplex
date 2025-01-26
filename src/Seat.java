public class Seat {
    String id;

    public Seat(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "id='" + id + '\'' +
                '}';
    }
}