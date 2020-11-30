package LibrarySystem;

import sun.util.calendar.Gregorian;
import sun.util.resources.cldr.aa.CalendarData_aa_ER;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class LoanedBook {
    private GregorianCalendar startDate;
    private GregorianCalendar dueBy;
    private String returned;
    private Book book;
    private Student student;
    private int fine;


    public LoanedBook(Student student, Book book, GregorianCalendar startDate, GregorianCalendar dueBy, String returned, int fine) {
        setStartDate(startDate);
        setDueBy(dueBy);
        setStudent(student);
        setReturned(returned);
        setBook(book);
        setFine(fine);


    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public GregorianCalendar getStartDate() {
        return startDate;
    }

    public void setStartDate(GregorianCalendar startDate) {
        this.startDate = startDate;
    }

    public GregorianCalendar getDueBy() {
        return dueBy;
    }

    public void setDueBy(GregorianCalendar dueBy) {
        this.dueBy = dueBy;
    }

    public String isReturned() {
        return returned;
    }

    public void setReturned(String returned) {


        this.returned = returned;
    }

    public String toString() {
        String str = super.toString() + "Date Issued: ";

        if (startDate.equals(0))
            str += "No date specified";
        else
            str += startDate.get(Calendar.DATE) + "-" + startDate.get(Calendar.MONTH) + "-" +
                    startDate.get(Calendar.YEAR);
        return str;
    }


    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {

        Calendar today = GregorianCalendar.getInstance();
        int daysPassed = today.get(Calendar.DATE) - startDate.get(Calendar.DATE);

        if (daysPassed >= 30) //30 days passed, fine will be given
            this.fine = 10;
        else if (daysPassed>= 60)//after 60 days max fine will be given
            this.fine = 60;
        else
            this.fine = 0;
    }
}
