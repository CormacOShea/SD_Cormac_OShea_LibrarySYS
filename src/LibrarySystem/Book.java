package LibrarySystem;

public class Book {
    private String title;
    private String author;
    private int pages;
    private String status;
    private int quantity;

    public Book(String title, String author, int pages, int quantity){
        setTitle(title);
        setAuthor(author);
        setPages(pages);
        setQuantity(quantity);


    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String toString(){
        return "Book details are as follows: title: " + getTitle() + " author: " + getAuthor() +
                " pages: " + getPages() + " quantity: " + getQuantity() + " status: " + getStatus();
    }
}
