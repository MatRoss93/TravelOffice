package Model;

public abstract class Trip {
    private static int id = 0;
    private int idWycieczki;
    private Date tripStartDate;
    private Date tripEndDate;
    private String destination;
    private double price;

    public Trip() {

    }
    public Trip(Date start, Date end, String descr) {
        this.tripStartDate = start;
        this.tripEndDate = end;
        this.destination = descr;
    }

    public Trip(Date start, Date end, String descr, double price) {
        this.tripStartDate = start;
        this.tripEndDate = end;
        this.destination = descr;
        this.price = price;
        id++;
        this.idWycieczki = id;
    }

    public int getIdWycieczki() {
        return idWycieczki;
    }

    public Date getTripStartDate() {
        return tripStartDate;
    }

    public void setTripStartDate(Date tripStartDate) {
        this.tripStartDate = tripStartDate;
    }

    public Date getTripEndDate() {
        return tripEndDate;
    }

    public void setTripEndDate(Date tripEndDate) {
        this.tripEndDate = tripEndDate;
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
                "tripStartDate=" + tripStartDate +
                ", tripEndDate=" + tripEndDate +
                ", destination='" + destination + '\'' +
                ", price=" + getPrice() +
                '}';
    }
}
