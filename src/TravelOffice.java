import Model.*;

public class TravelOffice {

    public static void main(String... args) {
        Address address = new Address("Prosta", "44-100", "Kosowo");
        Trip trip = new Trip(new Date(2019,10,10), new Date(2019,11,11), "Egipt");
        Customer customer = new Customer("John");
        customer.setAddress(address);
        customer.setTrip(trip);
        System.out.println(customer.toString());
    }
}
