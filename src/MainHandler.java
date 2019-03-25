import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.logging.Logger;


public class MainHandler implements UserInterface{



    private TravelOffice office;
    private TravelOfficeService officeService;
    private Scanner s;


    public MainHandler() {
        this.office = new TravelOffice();
        this.officeService = new TravelOfficeService();
        s = new Scanner(System.in);
    }

    @Override
    public Customer addCustomer() {

        String[] dane = new String[5];
        System.out.println("Name: ");
        dane[0] = s.next().toUpperCase();
        System.out.println("Surname: ");
        dane[1] = s.next().toUpperCase();
        System.out.println("Street: ");
        dane[2] = s.next().toUpperCase();
        System.out.println("Post code (??-???):");
        dane[3] = s.next();
        System.out.println("City: ");
        dane[4] = s.next().toUpperCase();
        Customer customer = new Customer(dane[0], dane[1], new Address(dane[2],dane[3], dane[4]));
        officeService.addCustomer(customer);

        return customer;
    }

    @Override
    public Trip addTrip() {

        String[] dane = new String[5];

        System.out.println("Date of departue: ");
        dane[0] = s.next();
        System.out.println("Date of return: ");
        dane[1] = s.next();
        System.out.println("Destination: ");
        dane[2] = s.next().toUpperCase();
        System.out.println("Price: ");
        dane[3] = s.next();
        System.out.println("A / D: ");
        dane[4] = s.next().toUpperCase();

        officeService.addTrip(dane);

        return null;
    }

    @Override
    public void assing() {
        showCustomers();
        showTrips();
        String[] dane = new String[2];

        System.out.println("\nPrzypisanie wycieczki do klienta o nazwisku: ");
        dane[0] = s.next();

        System.out.println("Kierunek wycieczki: ");
        dane[1] = s.next().toUpperCase();

        officeService.assign(dane);
    }

    @Override
    public boolean removeCustomer() {
        System.out.println("Likwidacja klienta o nazwisku: ");
        String name = s.next();
        return officeService.removeCustomer(name);
    }

    @Override
    public boolean removeTrip() {

        System.out.println("Likwidacja wycieczki do miejsca: ");
        String dest = s.next();

        return officeService.removeTrip(dest);
    }

    @Override
    public void showTrips() {
        officeService.showTrips();
    }

    @Override
    public void showCustomers() {
        officeService.showCustomers();
    }
}
