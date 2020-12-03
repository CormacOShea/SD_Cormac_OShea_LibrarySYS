package LibrarySystem;

import java.io.Serializable;

/**
 *  Represents an instantiable class which defines a Book. This class contains
 *  exception-handling code in some of its mutators to prevent bad input
 * @author Cormac O'Shea
 */
public class Book implements Serializable {
    private int id;
    private String title;
    private String author;
    private int pages;
    private int maxTime=30;
    private int quantity;
    private static int count=0;

    /**
     * Book multi-argument constructor. Calls the 6 mutators and the incrementCount() method to
     * initialise the attributes of a Book object with some user-supplied values. The Book ID is
     * set internally using the value of the count attribute to ensure unique Book ID values.
     * @param title the title of the book
     * @param author the author of the book
     * @param pages the number of pages in the book
     * @param quantity the number of books available in the system at that time
     */
    public Book(String title, String author, int pages, int quantity){
        setId(id);
        setTitle(title);
        setAuthor(author);
        setPages(pages);
        autoIncrement();
        setId(count);
        setQuantity(quantity);


    }

    /**
     * Method to get the ID of the book object
     *
     * @return an integer value specifying the ID of a Book object
     */

    public int getId() {
        return id;
    }

    /**
     * Method to set the ID of a Book object
     * @param id the id number of the Book
     */



    public void setId(int id) {
        this.id = id;
    }

    /**
     * Method to increment the static count attribute of the class, this is to ensure
     * that every Book object will have a unique ID value, as it tracks the value of this attribute
     */

    private static void autoIncrement(){
        count++;
    }

    /**
     * Method to get the title of the Book
     * @return a String value specifying th title of a Book object
     */

    public String getTitle() {
        return title;
    }

    /**
     * Method to set the title of the book object
     * @param title the title of the Book
     * @throws IllegalArgumentException In the case of an invalid title
     */

    public void setTitle(String title) {
        if (title==null || title.equals(""))
            throw new IllegalArgumentException("The book title must be given some value");

        this.title = title;
    }

    /**
     * Method to get the author of the Book object
     * @return a String value specifying the author of a Book object
     */

    public String getAuthor() {
        return author;
    }

    /**
     * Method to set the author of the Book object
     * @param author the author of the Book
     */

    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Method to get the number of pages of the book object
     * @return an integer value specifying the number of pages of a Book object
     */

    public int getPages() {
        return pages;
    }

    /**
     * Method to set the number of pages of the book object
     * @param pages the number of pages in the Book
     */

    public void setPages(int pages) {
        this.pages = pages;
    }

    /**
     * Method to get the quantity of that particular Book object
     * @return
     */

    public int getQuantity() {
        return quantity;
    }

    /**
     * Method to set the quantity of a book object
     * @param quantity the quantity of the particular Book
     */

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Method to get the state of a Book object
     * @return a String value specifying the state of a Book object
     */



    public String toString(){
         return  "Id: " +getId() + " title: " + getTitle() + " author: " + getAuthor() +
                " pages: " + getPages() + " quantity: " + getQuantity();


    }
}
