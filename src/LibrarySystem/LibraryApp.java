package LibrarySystem;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.stream.Collector;

public class LibraryApp extends JFrame implements ActionListener {
    private JMenu studentMenu;
    private JMenu bookMenu;
    private JMenu AdminMenu;
    private JLabel imgLabel;
    private JLabel label1;
    private ImageIcon image1;
    private JPanel owlPanel;
    private JButton studentButton;
    ArrayList<Student> students = new ArrayList();
    ArrayList<Book> books = new ArrayList();



    public LibraryApp(){
        setTitle("Library System");


        setIconImage(new ImageIcon(getClass().getResource("book.png")).getImage());


        createStudentMenu();
        createBookMenu();



        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.setBackground(Color.PINK);
        menuBar.add(this.studentMenu);
        menuBar.add(this.bookMenu);

        setSize(400,350);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());



        this.studentButton = new JButton("Edit");
        this.studentButton.addActionListener(this);
        image1 = new ImageIcon(getClass().getResource("owl2.png"));

       label1 = new JLabel(image1);
        add(label1);







    }

   public static void main(String[] args) {
        LibraryApp app = new LibraryApp();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);



    }






    private void createStudentMenu(){
        JMenuItem item;

        this.studentMenu = new JMenu("Students");

        item = new JMenuItem("Register");
        item.addActionListener(this);

        this.studentMenu.add(item);


        studentMenu.addSeparator();//adds a horizontal separator line

        item = new JMenuItem("Quit");
        item.addActionListener(this);

        this.studentMenu.add(item);


    }

    private void createBookMenu(){
        JMenuItem item;

        bookMenu = new JMenu("Books");

        item = new JMenuItem("Manage");
        item.addActionListener(this);

        bookMenu.add(item);

        item = new JMenuItem("View Overdue");
        item.addActionListener(this);

        bookMenu.add(item);
    }
    public void registerStudents(){

        Student s1 = new Student("t00200298","Cormac O'Shea","Computing with Software Development");
        Student s2 = new Student("t00110234","Jurgen Klopp","Sports with Leisure");
        Student s3 = new Student("t02132354","Mo Salah","Sports with Leisure");


        ArrayList<Student> allStudents = new ArrayList<Student>(Arrays.asList(s1,s2,s3));

        String choice;

        do{
            choice = JOptionPane.showInputDialog("1. Add a Student\n2. View Students\n3.Quit\n\nInvalid choice entered!! Must be between 1 and 3 inclusive");

            int choiceAsInt = Integer.parseInt(choice);

            while (choiceAsInt<1 || choiceAsInt>5){
                choice = JOptionPane.showInputDialog("1. Add a Student\\n2. View Students\\n3.Quit\\n\\nInvalid choice entered!! Must be between 1 and 3 inclusive");

                choiceAsInt = Integer.parseInt(choice);

            }

            switch (choice){
                case "1":
                    addStudent(allStudents);
                    break;

                case "2":
                    viewStudents(allStudents);

            }
        }while (!choice.equals("3"));
        JOptionPane.showMessageDialog(null,"Thanks for using the system!",
                "Farewell",JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);


    }


    public static void addStudent(ArrayList<Student> allStudents){
        boolean valid;
        String Tnumber;

        Tnumber = JOptionPane.showInputDialog("Please enter the tnumber of the student");

        while (!Tnumber.equals("")) {
            valid = false;
            int i;

            while (!valid) {

                if (Tnumber.length()!=8){
                    JOptionPane.showMessageDialog(null,"Invalid tnumber","Invalid",JOptionPane.INFORMATION_MESSAGE);

                }

                 if
                (Tnumber.length() == 8)  {
                    for (i = 0; i <= 7 && Character.isDigit(Tnumber.charAt(i)); i++)

             if (i==9 && Tnumber.charAt(0)=='t' || Tnumber.charAt(0)=='T' ){
                 JOptionPane.showMessageDialog(null,"Valid tnumber entered","Valid!",
                         JOptionPane.INFORMATION_MESSAGE);
             }
                    else {
                        Tnumber = JOptionPane.showInputDialog("Invalid tnumber!! Please re-enter");
             }

                }

            }
        }
        String name = JOptionPane.showInputDialog("Please enter the name of the Student");

        String course = JOptionPane.showInputDialog("Please enter the course of the Student");


        Student s = new Student(Tnumber,name,course);

        allStudents.add(s);
        JOptionPane.showMessageDialog(null,"Student now created and added to the system!",
                "Student added",JOptionPane.INFORMATION_MESSAGE);

    }

    private static void viewStudents(ArrayList<Student> allStudents){
        String allStudentData="";
        Student st;

        Iterator<Student> iterator = allStudents.iterator();

        while (iterator.hasNext()){
            st = iterator.next();
            if (st !=null)
                allStudentData += st + "\n";

        }

        JOptionPane.showMessageDialog(null,allStudentData,"List of all Students",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void manageBook(){

        Book b1 = new Book(1,"Harry Potter and the Goblet of Fire","J.K Rowling",654,6);
        Book b2 = new Book(2,"Harry Potter and the Philosopher's Stone","J.K Rowling",345,3);
        Book b3 = new Book(3,"Harry Potter and the Prisoner of Azkaban","J.K Rowling",456,2);

        ArrayList<Book> allBooks = new ArrayList<Book>(Arrays.asList(b1,b2,b3));

        String choice;

        do {
            choice = JOptionPane.showInputDialog("1. Add a Book\n2.Amend a Book\n3. Remove a Book" +
                    "\n4. View Books\n5. Quit\n\nPlease enter your choice");

            int choiceAsInt = Integer.parseInt(choice);

            while (choiceAsInt<1 || choiceAsInt >5){

                choice = JOptionPane.showInputDialog("1. Add a Book\n2. Amend a Book\n3. Remove a Book" +
                        "\n4. View Books\n5. Quit\n\nInvalid choice entered!! Must be between 1 and 5 inclusive");

                choiceAsInt = Integer.parseInt(choice);

            }

            switch (choice){
                case "1":
                    addBook(allBooks);
                    break;

                case "2":
                    amendBook(allBooks);
                    break;

                case "3":
                    removeBook(allBooks);
                    break;

                case "4":
                    viewBooks(allBooks);
            }


        }while (!choice.equals("5"));

        JOptionPane.showMessageDialog(null,"Thanks for using the system!",
                "Farewell", JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);


    }

    private static void addBook(ArrayList<Book> allBooks) {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Please enter the id of the Book"));
        String title = JOptionPane.showInputDialog("Please enter the title of the Book");
        String author = JOptionPane.showInputDialog("Please enter the author of the Book");
        int pages = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number of pages of the Book"));
        int quantity = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number of copies of the Book"));

        Book b = new Book(id,title,author,pages,quantity);

        allBooks.add(b);
        JOptionPane.showMessageDialog(null,"Book now created and added to the system",
                "Book Added",JOptionPane.INFORMATION_MESSAGE);

    }

    private static void amendBook(ArrayList<Book> allBooks){
        ArrayList<Book> foundBooks = new ArrayList<Book>();
        String searchKey = JOptionPane.showInputDialog("Please enter the title of the Book you wish to amend");

        for (Book bk: allBooks)
            if (bk.getTitle().toLowerCase().contains(searchKey.toLowerCase()))
                foundBooks.add(bk);

        String text="";

        for (Book bk: foundBooks)
            if (bk !=null){
                text +=bk + "\n";
            }
        int searchID = Integer.parseInt(JOptionPane.showInputDialog("The following books matched your search phrase\n\n" + text +
                "\n\nEnter the id of the one you want to amend"));

            Book bookToAmend = null;

            for (Book bk : allBooks)
                if (bk != null && bk.getId()==searchID)
                    bookToAmend = bk;

            String amendChoice = JOptionPane.showInputDialog("The details of the product you wish to amend are:\n\n " +
                    bookToAmend + "\n\n1. Amend Title\n2. Amend Author\n3. Amend pages " +
                    "\n4. Amend quantity\n5. Cancel Amendment\n\nPlease enter your choice");

                    int amendChoiceAsInt = Integer.parseInt(amendChoice);

                while (amendChoiceAsInt<1 || amendChoiceAsInt>5){
                    amendChoice = JOptionPane.showInputDialog("The details of the book you wish to amend are:\n\n" +
                           bookToAmend + "\n\n1. Amend Title\n2. Amend Author\n3. Amend pages" +
                            "\n4. Amend quantity\n5. Cancel Amendment\n\nInvalid choice entered!! Must be between 1 and 5 inclusive");

                    amendChoiceAsInt = Integer.parseInt(amendChoice);
                }

                switch (amendChoice){
                    case "1":
                        String newtitle =JOptionPane.showInputDialog("Please enter the new title for the book");

                        bookToAmend.setTitle(newtitle);

                        break;

                    case "2":
                        String newauthor = JOptionPane.showInputDialog("Please enter the new author for the book");

                        bookToAmend.setAuthor(newauthor);

                        break;

                    case "3":
                        int newpages = Integer.parseInt(JOptionPane.showInputDialog("Please enter the new number of pages for the book"));

                        bookToAmend.setPages(newpages);

                        break;

                    case "4":
                        int newquantity = Integer.parseInt(JOptionPane.showInputDialog("Please enter the new quantity of that particular book"));

                        bookToAmend.setQuantity(newquantity);

                        break;


                }

                JOptionPane.showMessageDialog(null, "Book details now amended!",
                        "Book Amended",JOptionPane.INFORMATION_MESSAGE);

    }

    private static void removeBook(ArrayList<Book> allBooks) {
        ArrayList<Book> foundBooks = new ArrayList<Book>();
        String searchKey = JOptionPane.showInputDialog("Please enter the book you wish to remove");


        for (Book bk: allBooks)
            if (bk.getTitle().toLowerCase().contains(searchKey.toLowerCase()))
                foundBooks.add(bk);

        String text="";

        for (Book bk: foundBooks)
            if (bk != null){
                text+= bk + "\n";
            }

        int searchID = Integer.parseInt(JOptionPane.showInputDialog("The following books matched your search phrase\n\n" + text +
                "\n\nPlease enter the id of the one you want to remove"));

        Book bookToRemove=null;

        for (Book bk: allBooks)
            if (bk !=null && bk.getId()==searchID)
                bookToRemove = bk;

        int removeChoice = JOptionPane.showConfirmDialog(null,"The details of the book you wish to remove are\n\n" +
                bookToRemove + "\n\nAre you sure you wish to remove this book?","Book Removal Confirmation",JOptionPane.YES_NO_CANCEL_OPTION);

        if (removeChoice==JOptionPane.YES_OPTION){
            allBooks.remove(bookToRemove);
            JOptionPane.showMessageDialog(null,"Book now removed from the system!",
                    "Book Removed",JOptionPane.INFORMATION_MESSAGE);
        }
        else
            JOptionPane.showMessageDialog(null,"Book removal cancelled",
                    "Book Not Removed",JOptionPane.INFORMATION_MESSAGE);

        foundBooks.clear();

    }

    private static void viewBooks(ArrayList<Book> allBooks) {
        String allBookData="";
        Book bk;

        Iterator<Book> iterator = allBooks.iterator();

        while (iterator.hasNext()){
            bk = iterator.next();
            if (bk !=null)
                allBookData += bk + "\n";
        }

        JOptionPane.showMessageDialog(null,allBookData,
                "List of all Books",JOptionPane.INFORMATION_MESSAGE);
    }


    //when a menu item is clicked, response starts here
    public void actionPerformed(ActionEvent e) {
        String menuName;
        menuName = e.getActionCommand();
        if (menuName == "Manage") {
            this.manageBook();
        }

        else if (menuName == "Register"){
            this.registerStudents();

        }
            if (menuName.equals("Quit"))
                JOptionPane.showMessageDialog(null, "Now closing window", "Closing Window",
                        JOptionPane.INFORMATION_MESSAGE);
            int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit this application?",
                    "Exiting Application Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);
            if (choice == JOptionPane.YES_OPTION)
                dispose();
        }

    }

