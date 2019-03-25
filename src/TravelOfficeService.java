import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.logging.Logger;

public class TravelOfficeService {

    private TravelOffice office;
    private static Logger logger = Logger.getLogger("src");
    private DateTimeFormatter drf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public TravelOfficeService() {
        office = new TravelOffice();
    }
    public boolean addCustomer(Customer customer) {
        logger.info("Add client: ");
        if(office.addCustomer(customer)) {
            office.addCustomer(customer);
        }
        return false;
    }

    public boolean addTrip(String[] dane) {
        logger.info("Add trip");
        try {
            Trip trip = null;
            if (dane[4].equals("A")) {
                trip = new AboardTrip(LocalDate.parse(dane[0], drf), LocalDate.parse(dane[1], drf), dane[2], Double.parseDouble(dane[3]));
                logger.info("Aboard trip added");
            } else {
                trip = new DomesticTrip(LocalDate.parse(dane[0], drf), LocalDate.parse(dane[1], drf), dane[2], Double.parseDouble(dane[3]));
                logger.info("Domestic trip added");
            }
            office.addTrip(dane[2], trip);
            return true;
        } catch(DateTimeParseException e) {
            logger.severe("Something went wrong");
            return false;
        }
    }

    public boolean removeTrip(String dest) {

        try {
            return office.removeTrip(dest);
        } catch(NoSuchTripException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public boolean removeCustomer(String name) {

        if(office.getCustomers().removeIf(x -> (x.getName().equals(name))))
            return true;
        else {
            System.out.println("Nie ma takiego klienta");
            return false;
        }
    }

    public void assign(String[] dane) {
        try {
            office.findCustomerByName(dane[0]).setTrip(office.getTrips().get(dane[1]));
        } catch (NoSuchCustomerException e) {
            logger.warning(e.toString());
            System.out.println(e.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void showCustomers() {
        office.getCustomers().forEach(x-> System.out.println(x.toString()));
    }

    public void showTrips() {
        if(office.getTrips().isEmpty())
            System.out.println("There is no trips in database");
        office.getTrips().values().forEach(y -> System.out.println(y));
    }
}
