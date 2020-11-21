package LibrarySystem;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

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
    public void editStudents(){


    }

    public void manageBook(){

        Book b1 = new Book("Harry Potter and the Goblet of Fire","J.K Rowling",654,6);
        Book b2 = new Book("Harry Potter and the Philosopher's Stone","J.K Rowling",345,3);
        Book b3 = new Book("Harry Potter and the Prisoner of Azkaban","J.K Rowling",456,2);

        ArrayList<Book> allBooks = new ArrayList<Book>(Arrays.asList(b1,b2,b3));

        String choice;

        do {
            choice = JOptionPane.showInputDialog("1. Add a Student\n2.Amend a Student\n3. Remove a Student" +
                    "\n4. Quit\n\nPlease enter your choice");

            int choiceAsInt = Integer.parseInt(choice);

            while (choiceAsInt<1 || choiceAsInt >4){

                choice = JOptionPane.showInputDialog("1. Add a Student\n2. Amend a Student\n3. Remove a Student" +
                        "\n5. Quit\n\nInvalid choice entered!! Must be between 1 and 5 inclusive");

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
            }


        }while (!choice.equals("4"));

        JOptionPane.showMessageDialog(null,"Thanks for using the system!",
                "Farewell", JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);


    }

    private static void addBook(ArrayList<Book> allBooks) {
        String title = JOptionPane.showInputDialog("Please enter the title of the Book");
        String author = JOptionPane.showInputDialog("Please enter the author of the Book");
        int pages = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number of pages of the Book"));
        int quantity = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number of copies of the Book"));

        Book b = new Book(title,author,pages,quantity);

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
        String searchTitle = JOptionPane.showInputDialog("The following books matched your search phrase\n\n" + text +
                "\n\nEnter the title of the one yu want to amend");

            Book bookToAmend = null;

            for (Book bk : allBooks)
                if (bk != null && bk.getTitle()==searchTitle)
                    bookToAmend = bk;

            String amendChoice = JOptionPane.showInputDialog("The details of the product you wish to amend are:\n\n " +
                    bookToAmend + "\n\n1. Amend Title\n2. Amend Author\n3. Amend pages " +
                    "\n4. Amend quantity\n5. Cancel Amendment\n\nPlease enter your choice");

                    int amendChoiceAsInt = Integer.parseInt(amendChoice);

                while (amendChoiceAsInt<1 || amendChoiceAsInt>5){
                    amendChoice = JOptionPane.showInputDialog("The details of the book you wish to amend are:\n\n" +
                           bookToAmend + "\n\n1. Amend Title\n2. Amend Author\n3. Amend pages" +
                            "\n4. Amend quantity\n5. Cancel Amendment\n\nInvalid choice entered!! Must be between 1 and 5 inclusive");
                    
                }
    }

    //when a menu item is clicked, response starts here
    public void actionPerformed(ActionEvent e) {
        String menuName;
        menuName = e.getActionCommand();
        if (menuName == "Manage") {
            this.manageBook();
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

