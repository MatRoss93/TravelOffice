import java.time.LocalDate;

public abstract class Trip {
    private static int id = 0;
    private int idWycieczki;
    /*
    private Date tripStartLocalDate;
    private Date tripEndLocalDate;
    */
    private String destination;
    private LocalDate tripStartLocalDate;
    private LocalDate tripEndLocalDate;
    private double price;

    public Trip() {

    }
    public Trip(LocalDate start, LocalDate end, String descr) {
        this.tripStartLocalDate = start;
        this.tripEndLocalDate = end;
        this.destination = descr;
    }

    public Trip(LocalDate start, LocalDate end, String descr, double price) {
        this.tripStartLocalDate = start;
        this.tripEndLocalDate = end;
        this.destination = descr;
        this.price = price;
        id++;
        this.idWycieczki = id;
    }

    public Trip(String descr, double price) {

        this.destination = descr;
        this.price = price;
        id++;
        this.idWycieczki = id;
    }

    public int getIdWycieczki() {
        return idWycieczki;
    }

    public LocalDate getTripStartLocalDate() {
        return tripStartLocalDate;
    }

    public void setTripStartLocalDate(LocalDate tripStartLocalDate) {
        this.tripStartLocalDate = tripStartLocalDate;
    }

    public LocalDate getTripEndLocalDate() {
        return tripEndLocalDate;
    }

    public void setTripEndLocalDate(LocalDate tripEndLocalDate) {
        this.tripEndLocalDate = tripEndLocalDate;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "idWycieczki=" + idWycieczki +
                ", destination='" + destination + '\'' +
                ", tripStartLocalDate=" + tripStartLocalDate +
                ", tripEndLocalDate=" + tripEndLocalDate +
                ", price=" + price +
                '}';
    }
}
