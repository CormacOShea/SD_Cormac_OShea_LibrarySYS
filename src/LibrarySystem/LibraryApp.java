package LibrarySystem;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
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

        item = new JMenuItem("Edit");
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

        item = new JMenuItem("Add");
        item.addActionListener(this);

        bookMenu.add(item);

        item = new JMenuItem("View Overdue");
        item.addActionListener(this);

        bookMenu.add(item);
    }
    public void editStudents(){
        String choice;

        do {
            choice = JOptionPane.showInputDialog("1. Add a Student\n2.Amend a Student\n3. Remove a Student" +
                    "\n4. View all Students in the system\n5. Quit\n\nPlease enter your choice");

            int choiceAsInt = Integer.parseInt(choice);

            while (choiceAsInt<1 || choiceAsInt >5){

                choice = JOptionPane.showInputDialog("1. Add a Student\n2. Amend a Student\n3. Remove a Student" +
                        "\n4. View all Students on the system\n5. Quit\n\nInvalid choice entered!! Must be between 1 and 5 inclusive");

                choiceAsInt = Integer.parseInt(choice);

            }


        }while (!choice.equals("5"));

        JOptionPane.showMessageDialog(null,"Thanks for using the system!",
                "Farewell", JOptionPane.INFORMATION_MESSAGE);

    }

    //when a menu item is clicked, response starts here
    public void actionPerformed(ActionEvent e) {
        String menuName;
        menuName = e.getActionCommand();
        if (menuName == "Edit") {
            this.editStudents();
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

