public class Customer {

    private String name;
    private String surname;
    private Address address;
    private Trip trip;

    @SuppressWarnings("unused")
    public Customer() {

    }

    Customer(String name, String surname, Address address) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.trip = null;
    }

    @SuppressWarnings("unused")
    public Customer(String name, Address address, Trip trip) {
        this.name = name;
        this.address = address;
        this.trip = trip;
    }

    @SuppressWarnings("unused")
    public void setAddress(Address address) {
        this.address = address;
    }

    public void setTrip(Trip trip) {

        this.trip = trip;
    }

    String getName() {
        return name;
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
