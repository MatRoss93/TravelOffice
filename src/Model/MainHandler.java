package Model;

import java.util.Scanner;

public class MainHandler implements UserInterface{

    private TravelOffice office;
    private Scanner s = null;
    public MainHandler() {
        this.office = new TravelOffice();
        s = new Scanner(System.in);
    }

    @Override
    public Customer addCustomer() {
        String[] dane = new String[4];

        System.out.println("Nazwisko klienta: ");
        dane[0] = s.next();
        System.out.println("Nazwa ulicy: ");
        dane[1] = s.next();
        System.out.println("Kod pocztowy (??-???):");
        dane[2] = s.next();
        System.out.println("Miasto: ");
        dane[3] = s.next();
        Customer customer = new Customer(dane[0], new Address(dane[1],dane[2], dane[3]));
        office.addCustomer(customer);

        return customer;
    }

    @Override
    public Trip addTrip() {
        Trip trip = null;
        String[] dane = new String[5];

        System.out.println("Data wyjazdu: ");
        dane[0] = s.next();
        System.out.println("Data powrotu: ");
        dane[1] = s.next();
        System.out.println("Gdzie: ");
        dane[2] = s.next();
        System.out.println("Cena: ");
        dane[3] = s.next();
        System.out.println("Z / K: ");
        dane[4] = s.next();

        if(dane[4].equals("Z")) {
            trip = new AboardTrip(Date.of(dane[0]), Date.of(dane[1]), dane[2], Double.parseDouble(dane[3]));
        }
        else {
            trip = new DomesticTrip(Date.of(dane[0]), Date.of(dane[1]), dane[2], Double.parseDouble(dane[3]));
        }
        office.addTrip(dane[2], trip);
        return trip;
    }

    @Override
    public void assing() {
        showCustomers();
        showTrips();
        String[] dane = new String[2];

        System.out.println("Przypisanie wycieczki do klienta o nazwisku: ");
        dane[0] = s.next();
        System.out.println("Kierunek wycieczki: ");
        dane[1] = s.next();

        office.findCustomerByName(dane[0]).setTrip(TravelOffice.getTrips().get(dane[1]));
    }

    @Override
    public boolean removeCustomer() {

        System.out.println("Likwidacja klienta o nazwisku: ");
        String name = s.next();
        return office.removeCustomer(office.findCustomerByName(name));
    }

    @Override
    public boolean removeTrip() {

        System.out.println("Likwidacja wycieczki do miejsca: ");
        String dest = s.next();
        return office.removeTrip(dest);
    }

    @Override
    public void showTrips() {
        office.showTrips();
    }

    @Override
    public void showCustomers() {
        office.showCustomers();
    }
}
