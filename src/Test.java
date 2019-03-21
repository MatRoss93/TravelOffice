import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Test {

    public static Logger logger = Logger.getLogger("src");
    public static FileHandler fh;

    static {
        try {
            fh = new FileHandler("log.txt");
            fh.setFormatter(new SimpleFormatter());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String... args) {

        logger.setUseParentHandlers(false);
        logger.addHandler(fh);
        TravelOffice office = new TravelOffice();
        MainHandler mh = new MainHandler();


        /*
        office.addTrip("Kalkuta",new DomesticTrip(new Date(2018,10,20), new Date(2018, 10,30),"Kalkuta",0));
        office.addCustomer(new Customer("John", new Address("Prosta", "44-100", "Kosowo"),
                new DomesticTrip(new Date(2019,10,10), new Date(2019,11,11),
                        "Egipt", 10)));

        office.addCustomer(new Customer("Widia", new Address("Bliat", "44-110", "Czelabiańsk"),
                new DomesticTrip(new Date(2019,10,10), new Date(2019,11,11),
                        "Polska",1500, 100)));
        */
        office.addCustomer(new Customer("Hadim", new Address("Prosta", "44-100", "Egipt"),
                new AboardTrip(LocalDate.of(2019,10,10), LocalDate.of(2019,11,11),
                        "Egipt", 1000, 100)));
        
        System.out.println("Co zrobić: \n" +
                "1. Dodaj klienta \n" +
                "2. Dodaj wycieczkę \n" +
                "3. Przypisz wycieczkę do klienta \n" +
                "4. Pokaż klientów \n" +
                "5. Pokaż wycieczki \n" +
                "6. Usuń klienta\n" +
                "7. Usuń wyczieczkę\n" +
                "0. Wyjdź");
        Scanner sc = new Scanner(System.in);
        System.out.print("Co chcesz zrobić : ");
        int flowControll = sc.nextInt();

        while(flowControll != 0) {

            switch (flowControll) {
                case 1:
                    mh.addCustomer();
                    break;
                case 2:
                    mh.addTrip();
                    break;
                case 3:
                    mh.assing();
                    break;
                case 4:
                    mh.showCustomers();
                    break;
                case 5:
                    mh.showTrips();
                    break;
                case 6:
                    mh.removeCustomer();
                    break;
                case 7:
                    mh.removeTrip();
                    break;
                case 9:
                    office.getInfo();
                    break;
                case 0:
                    System.out.println("Koniec programu");
                    break;
                default:
                    System.out.println("Wybierz jedną z opcji");
            }
            System.out.println();
            System.out.println("Co zrobić: \n" +
                    "1. Dodaj klienta \n" +
                    "2. Dodaj wycieczkę \n" +
                    "3. Przypisz wycieczkę do klienta \n" +
                    "4. Pokaż klientów \n" +
                    "5. Pokaż wycieczki \n" +
                    "6. Usuń klienta\n" +
                    "7. Usuń wyczieczkę\n" +
                    "0. Wyjdź");
            System.out.print("Co chcesz zrobić : ");
            flowControll = sc.nextInt();

        }
        sc.close();
    }
}
