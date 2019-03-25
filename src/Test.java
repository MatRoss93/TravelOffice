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
        String[] str = {"abcd"};
        System.out.println(str[0].substring(0,1).toUpperCase()+str[0].substring(1));
        
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
