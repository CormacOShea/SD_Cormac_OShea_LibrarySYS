package LibrarySystem;

import sun.util.calendar.Gregorian;
import sun.util.resources.cldr.aa.CalendarData_aa_ER;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class LoanedBook {
    private GregorianCalendar dateIssued;
    private String overdue;
    private Book id;
    private Student Tnumber;
    private int fine;


    public LoanedBook(Student Tnumber, Book id, GregorianCalendar dateIssued, boolean overdue, int fine) {
        setId(id);
        setTnumber(Tnumber);
        setDateIssued(dateIssued);
        setOverdue(overdue);
        setFine(fine);


    }

    public GregorianCalendar getDateIssued() {
        return dateIssued;
    }

    public void setDateIssued(GregorianCalendar date) {
        this.dateIssued = date;
    }

    public boolean isOverdue() {
        return true;
    }

    public void setOverdue(boolean overdue) {

        if (overdue==true)
        this.overdue = "yes";
        else
            this.overdue = "no";
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

    /// public int getFine() {
    //   return fine;
    // }

    // public void setFine(int fine) {
    //    this.fine = fine;
    //}

    public String toString() {
        String str = super.toString() + "Date Issued: ";

        if (dateIssued.equals(0))
            str += "No date specified";
        else
            str += getDateIssued().get(Calendar.DATE) + "-" + getDateIssued().get(Calendar.MONTH) + "-" +
                    getDateIssued().get(Calendar.YEAR);
        return str;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {

        Calendar today = GregorianCalendar.getInstance();
        int daysPassed = today.get(Calendar.DATE) - getDateIssued().get(Calendar.DATE);

        if (daysPassed >= 30) //30 days passed, fine will be given
            this.fine = 10;
        else if (daysPassed>= 60)//after 60 days max fine will be given
            this.fine = 60;
        else
            this.fine = 0;
    }
}
