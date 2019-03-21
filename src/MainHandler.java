import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.logging.Logger;


public class MainHandler implements UserInterface{

    private static Logger logger = Logger.getLogger("src");

    private TravelOffice office;
    private Scanner s = null;
    DateTimeFormatter drf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public MainHandler() {
        this.office = new TravelOffice();
        s = new Scanner(System.in);
    }

    @Override
    public Customer addCustomer() {
        logger.info("Dodaję klienta");
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
        logger.info("Dodaję wycieczkę");
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
        try {
            if (dane[4].equals("Z")) {
                trip = new AboardTrip(LocalDate.parse(dane[0], drf), LocalDate.parse(dane[1], drf), dane[2], Double.parseDouble(dane[3]));
            } else {
                trip = new DomesticTrip(LocalDate.parse(dane[0], drf), LocalDate.parse(dane[1], drf), dane[2], Double.parseDouble(dane[3]));
            }
            office.addTrip(dane[2], trip);
            return trip;
        } catch(DateTimeParseException e) {
            logger.severe("Format daty inny niż yyyy-MM-dd lub przekroczony zakres dla jednego lub więcej pól");
            return null;
        }
    }

    @Override
    public void assing() {
        showCustomers();
        showTrips();
        String[] dane = new String[2];

        System.out.println("\nPrzypisanie wycieczki do klienta o nazwisku: ");
        dane[0] = s.next();

        System.out.println("Kierunek wycieczki: ");
        dane[1] = s.next();

        try {
            office.findCustomerByName(dane[0]).setTrip(TravelOffice.getTrips().get(dane[1]));
        } catch (NoSuchCustomerException e) {
            logger.warning(e.toString());
            System.out.println(e.toString());
            addCustomer();
        } catch (Exception e) {
            System.out.println(e.toString());
            addTrip();
        }
    }

    @Override
    public boolean removeCustomer() {

        System.out.println("Likwidacja klienta o nazwisku: ");
        String name = s.next();

        if(TravelOffice.getCustomers().removeIf(x -> (x.getName().equals(name))))
            return true;
        else {
            System.out.println("Nie ma takiego klienta");
            return false;
        }

    }
    /*
    @Override
    public boolean removeCustomer() {

        System.out.println("Likwidacja klienta o nazwisku: ");
        String name = s.next();
        try {
            return office.removeCustomer(office.findCustomerByName(name));
        } catch(NoSuchCustomerException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    */
    @Override
    public boolean removeTrip() {

        System.out.println("Likwidacja wycieczki do miejsca: ");
        String dest = s.next();
        try {
            return office.removeTrip(dest);
        } catch(NoSuchTripException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    @Override
    public void showTrips() {
        //office.showTrips();
        TravelOffice.getTrips().values().forEach(y -> System.out.println(y));

    }

    @Override
    public void showCustomers() {
        TravelOffice.getCustomers().forEach(x-> System.out.println(x.toString()));
        //office.showCustomers();
    }
}
