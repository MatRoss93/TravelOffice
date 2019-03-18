package Model;

public class Trip {

    private Date tripStartDate;
    private Date tripEndDate;
    private String destination;

    public Trip(Date start, Date end, String descr) {
        this.tripStartDate = start;
        this.tripEndDate = end;
        this.destination = descr;
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

    @Override
    public String toString() {
        return "Trip{" +
                "tripStartDate=" + tripStartDate.toString() +
                ", tripEndDate=" + tripEndDate.toString() +
                ", destination='" + destination + '\'' +
                '}';
    }
}
