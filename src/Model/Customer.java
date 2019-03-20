package Model;

public class Customer {

    private String name;
    private Address address;
    private Trip trip;

    public Customer() {

    }
    public Customer(String name) {
        this.name = name;

    }

    public Customer(String name, Address address) {
        this.name=name;
        this.address = address;
        this.trip = null;
    }
    public Customer(String name, Address address, Trip trip) {
        this.name = name;
        this.address = address;
        this.trip = trip;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setTrip(Trip trip) {

        this.trip = trip;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public Trip getTrip() {
        return trip;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", address=" + address +
                ", trip=" + trip +
                '}';
    }
}
