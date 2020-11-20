package LibrarySystem;

import sun.util.calendar.Gregorian;

import java.util.GregorianCalendar;

public class LoanedBook {
    private int id;
    private Book book;
    private GregorianCalendar date;

    public LoanedBook(int id, Book book, GregorianCalendar date) {
        setId(id);
        setBook(book);
        setDate(date);
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
}
