package LibrarySystem;

import sun.util.calendar.Gregorian;
import sun.util.resources.cldr.aa.CalendarData_aa_ER;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class LoanedBook  {
    private GregorianCalendar dateIssued;
    private boolean overdue = false;
    private Book id;
    private Student Tnumber;


    public LoanedBook(Student Tnumber, Book id, GregorianCalendar dateIssued, boolean overdue ) {
        setId(id);
        setTnumber(Tnumber);
        setDateIssued(dateIssued);
        setOverdue(overdue);


    }

    public GregorianCalendar getDateIssued() {
        return dateIssued;
    }

    public void setDateIssued(GregorianCalendar date) {
        this.dateIssued = date;
    }

    public boolean isOverdue() {
        return overdue;
    }

    public void setOverdue(boolean overdue) {
        this.overdue = overdue;
    }

    public Book getId() {
        return id;
    }

    public void setId(Book id) {
        this.id = id;
    }

    public Student getTnumber() {
        return Tnumber;
    }

    public void setTnumber(Student tnumber) {
        Tnumber = tnumber;
    }

    public String toString() {
        String str= super.toString() + "Date Issued: ";

        if (dateIssued.equals(0))
            str+="No date specified";
        else
            str+=getDateIssued().get(Calendar.DATE) + "-" + getDateIssued().get(Calendar.MONTH) + "-" +
                    getDateIssued().get(Calendar.YEAR);
        return str;
    }
}
