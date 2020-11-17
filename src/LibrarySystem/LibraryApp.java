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


        image1 = new ImageIcon(getClass().getResource("owl2.png"));

       label1 = new JLabel(image1);
        add(label1);







    }
    /**public void windowClosing(WindowEvent e){
        JOptionPane.showMessageDialog(null,"Now closing window", "Closing Window",
                JOptionPane.INFORMATION_MESSAGE);
        int choice = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit this application?",
                "Exiting Application Confirmation",JOptionPane.YES_NO_CANCEL_OPTION);

        if (choice==JOptionPane.YES_OPTION)
            dispose();
    }**/

   public static void main(String[] args) {
        LibraryApp app = new LibraryApp();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);



    }
    //when a menu item is clicked, response starts here
    public void actionPerformed(ActionEvent event) {
        String menuName;
        menuName = event.getActionCommand();

        if (menuName.equals("Quit"))
            JOptionPane.showMessageDialog(null,"Now closing window", "Closing Window",
                    JOptionPane.INFORMATION_MESSAGE);
        int choice = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit this application?",
                "Exiting Application Confirmation",JOptionPane.YES_NO_CANCEL_OPTION);

        if (choice==JOptionPane.YES_OPTION)
            dispose();



    }

    private void createStudentMenu(){
        JMenuItem item;

        studentMenu = new JMenu("Students");

        item = new JMenuItem("Add");
        item.addActionListener(this);

        studentMenu.add(item);

        item = new JMenuItem("View");
        item.addActionListener(this);

        studentMenu.add(item);

        studentMenu.addSeparator();//adds a horizontal separator line

        item = new JMenuItem("Quit");
        item.addActionListener(this);

        studentMenu.add(item);


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




}
