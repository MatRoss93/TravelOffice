package Model;

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

    public void showTrips() {

        System.out.print(trips.keySet() + " ");
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addTrip(String destination, Trip trip) {
        trips.put(destination, trip);
    }

    public boolean removeTrip(String destination) {
        if(trips.containsKey(destination)) {
            trips.remove(destination);
            return true;
        }
        return false;
    }

    public Customer findCustomerByName(String name) throws NullPointerException {

        for(Customer c: customers) {
            if(c.getName().equals(name))
                return c;
            }
        return null;
    }

    public boolean removeCustomer(Customer customer) {
        if(customers.contains(customer)) {
            customers.remove(customer);
            return true;
        }
        return false;
    }
    /*
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
