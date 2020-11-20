package LibrarySystem;

import sun.util.calendar.Gregorian;

import java.util.GregorianCalendar;

public class LoanedBook {
    private int id;
    private Book book;
    private Student student;
    private GregorianCalendar date;

    public LoanedBook(int id, Book book, GregorianCalendar date, Student student) {
        setId(id);
        setBook(book);
        setDate(date);
        setStudent(student);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public GregorianCalendar getDate() {
        return date;
    }


    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String toString() {
        return "id: " + getId() + "  " + getBook() + "start date: " + getDate() +
                "   " + getStudent();
    }
}
