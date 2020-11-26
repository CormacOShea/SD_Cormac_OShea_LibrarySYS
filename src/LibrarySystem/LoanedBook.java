package LibrarySystem;

import sun.util.calendar.Gregorian;
import sun.util.resources.cldr.aa.CalendarData_aa_ER;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class LoanedBook extends Book {
    private GregorianCalendar dateIssued;

    public LoanedBook(String title, String author, int pages, int quantity, GregorianCalendar dateIssued) {
        super(title, author, pages, quantity);
        setDateIssued(dateIssued);
    }

    public GregorianCalendar getDateIssued() {
        return dateIssued;
    }

    public void setDateIssued(GregorianCalendar date) {
        this.dateIssued = date;
    }

    public String toString() {
        String str= super.toString() + "Date Issued: ";

        if (dateIssued==null)
            str+="No date specified";
        else
            str+=getDateIssued().get(Calendar.DATE) + "-" + getDateIssued().get(Calendar.MONTH) + "-" +
                    getDateIssued().get(Calendar.YEAR);
        return str;
    }
}
