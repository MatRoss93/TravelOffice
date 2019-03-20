package Model;

public class AboardTrip extends Trip {

    private double insurance;

    public AboardTrip(Date start, Date end, String descr, double price, double insurance) {
        super(start, end, descr, price);
        this.insurance = insurance;
    }

    public AboardTrip(Date start, Date end, String descr, double price) {
        super(start, end, descr, price);
        this.insurance = 0;
    }

    public double getInsurance() {
        return insurance;
    }

    public void setInsurance(double insurance) {
        this.insurance = insurance;
    }

    @Override
    public double getPrice() {
        return super.getPrice() + getInsurance();
    }
}
