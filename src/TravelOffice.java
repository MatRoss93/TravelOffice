import java.util.*;

public class TravelOffice {

    private Set<Customer> customers;
    private Map<String, Trip> trips;

    public TravelOffice() {
        this.customers = new HashSet<>();
        this.trips = new HashMap<>();
    }

    public Map<String, Trip> getTrips() {
        return trips;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void showTrips() {

        System.out.print(trips.keySet() + " ");
    }

    public boolean addCustomer(Customer customer) {
        if(!customer.equals(null)) {
            customers.add(customer);
            return true;
        }
        return false;
    }

    public boolean addTrip(String destination, Trip trip) {
        if(!destination.equals("") && !trip.equals(null)) {
            trips.put(destination, trip);
            return true;
        }
        return false;
    }

    public boolean removeTrip(String destination) throws NoSuchTripException {
        if(trips.containsKey(destination.toUpperCase())) {
            trips.remove(destination.toUpperCase());
            return true;
        }
        throw new NoSuchTripException(destination);
    }

    public Customer findCustomerByName(String name) throws NoSuchCustomerException {

        for(Customer c: customers) {
            if(c.getName().equals(name.toUpperCase()))
                return c;
            }
        throw new NoSuchCustomerException(name);
    }

    public void getInfo() {
        for(Customer c : customers) {
            System.out.println(c.toString());
        }
    }




}
