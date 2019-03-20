import Model.*;

import java.util.Scanner;

public class Test {

    public static void main(String... args) {
        TravelOffice office = new TravelOffice();
        MainHandler mh = new MainHandler();


        office.addTrip("Kalkuta",new DomesticTrip(new Date(2018,10,20), new Date(2018, 10,30),"Kalkuta",0));
        office.addCustomer(new Customer("John", new Address("Prosta", "44-100", "Kosowo"),
                new DomesticTrip(new Date(2019,10,10), new Date(2019,11,11),
                        "Egipt", 10)));

        office.addCustomer(new Customer("Widia", new Address("Bliat", "44-110", "Czelabiańsk"),
                new DomesticTrip(new Date(2019,10,10), new Date(2019,11,11),
                        "Polska",1500, 100)));

        office.addCustomer(new Customer("Hadim", new Address("Prosta", "44-100", "Egipt"),
                new AboardTrip(new Date(2019,10,10), new Date(2019,11,11),
                        "Egipt", 1000, 100)));
        /*
        System.out.println("Liczba klientów: " + office.getCustomerCount());
        office.getInfo();
        System.out.println("Wyszukiwanie klienta: ");
        try {
            System.out.println(office.findCustomerByName("Tali").toString());
        } catch (NullPointerException e) {
            System.out.println("Nie ma takiego klienta");
        }
        System.out.println("Usuwanie klienta: ");
        System.out.println(office.removeCustomer(office.findCustomerByName("Tali")));
        office.getInfo();
        */
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
                case 7:
                    mh.removeTrip();
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