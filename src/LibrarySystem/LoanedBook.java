package LibrarySystem;

import sun.util.calendar.Gregorian;

import java.util.GregorianCalendar;

public class LoanedBook extends Book {
    private GregorianCalendar date;

    public LoanedBook(String title, String author, int pages, int quantity) {
        super(title, author, pages, quantity);
        setDate(date);
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public String toString() {
        return super.toString();
    }
}
