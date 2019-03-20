package Model;

public class Date {

    private int day;
    private int month;
    private int year;

    public Date(int year, int month, int day) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    public static Date of(String pattern) {
        String[] s = pattern.split("[-._]");
        int year = Integer.parseInt(s[2]);
        int month = Integer.parseInt(s[1]);
        int day = Integer.parseInt(s[0]);

        return new Date(year, month,day);
    }
    @Override
    public String toString() {
        return "Date{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }
}
