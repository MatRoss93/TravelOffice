public class NoSuchTripException extends Exception{

    String trip;

    public NoSuchTripException(String trip) {
        this.trip = trip;
    }

    public String toString() {
        return "W bazie nie ma podanej wycieczki " + this.trip;
    }
}
