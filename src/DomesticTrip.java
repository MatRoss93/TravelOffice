import java.time.LocalDate;

public class DomesticTrip extends Trip {

    private double ownArrivalDiscount;

    public DomesticTrip(LocalDate start, LocalDate end, String descr, double price, double ownArrivalDiscount) {
        super(start, end, descr, price);
        this.ownArrivalDiscount = ownArrivalDiscount;
    }

    public DomesticTrip(LocalDate start, LocalDate end, String descr, double price) {
        super(start, end, descr, price);
        this.ownArrivalDiscount = 0;
    }

    @Override
    public double getPrice() {
        return super.getPrice() - getOwnArrivalDiscount();
    }

    public double getOwnArrivalDiscount() {
        return ownArrivalDiscount;
    }

    public void setOwnArrivalDiscount(double ownArrivalDiscount) {
        this.ownArrivalDiscount = ownArrivalDiscount;
    }
}
