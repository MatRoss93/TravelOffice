import java.util.*;

public class TravelOffice {

    //private static int numOfCustomers = 0;
    private static Set<Customer> customers = new HashSet<>();
    private static Map<String, Trip> trips = new HashMap<>();
    public TravelOffice() {

    }
    public void showCustomers() {
        for(Customer c: customers) {
            System.out.println("Klient " + c.getName() + " ,zamieszkały: " + c.getAddress());
        }
    }

    public static Map<String, Trip> getTrips() {
        return trips;
    }

    public static Set<Customer> getCustomers() {
        return customers;
    }

    public static void setCustomers(Set<Customer> customers) {
        TravelOffice.customers = customers;
    }

    public void showTrips() {

        System.out.print(trips.keySet() + " ");
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addTrip(String destination, Trip trip) {
        trips.put(destination, trip);
    }

    public boolean removeTrip(String destination) throws NoSuchTripException {
        if(trips.containsKey(destination)) {
            trips.remove(destination);
            return true;
        }
        throw new NoSuchTripException(destination);
    }

    public Customer findCustomerByName(String name) throws NoSuchCustomerException {

        for(Customer c: customers) {
            if(c.getName().equals(name))
                return c;
            }
        throw new NoSuchCustomerException(name);
    }

    /*
    public boolean removeCustomer(Customer customer) throws NoSuchCustomerException{
        rci.customerToRemove(customer, name);
        if(customers.contains(customer)) {
            customers.remove(customer);
            return true;
        }
        throw new NoSuchCustomerException(customer.getName());
    }
    */
    /* ---- Element wykorzystywany w poprzedniej wersji ćwiczenia, ----
            ---- w której używano tablicy zamiast Collections ----
    public void addCustomer(Customer customer) {

        if(isFull()) {
            customers = extendList();
            customers[numOfCustomers] = customer;
            numOfCustomers++;
        } else {
            customers[numOfCustomers] = customer;
            numOfCustomers++;
        }
    }

    public boolean isFull() {
        return (customers.length) <= numOfCustomers;
    }


    public static Customer[] extendList() {
        int sizeOfList = numOfCustomers + 1;
        return Arrays.copyOf(customers, sizeOfList);
    }
    */
    public int getCustomerCount() {
        return customers.size();
    }

    public void getInfo() {
        for(Customer c : customers) {
            System.out.println(c.toString());
        }
    }




}
