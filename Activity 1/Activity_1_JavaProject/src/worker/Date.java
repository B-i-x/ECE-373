package worker;
public class Date {
    private int month;
    private int day;
    private int year;

    // Constructor
    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public String printDate() {
        return this.month + "/" + this.day + "/" + this.year;
    }
}