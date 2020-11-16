package LibrarySystem;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LibraryApp extends JFrame implements ActionListener {
    private JMenu studentMenu;
    private JMenu bookMenu;
    private JMenu AdminMenu;
    private JLabel imgLabel;
    private JLabel welcomeLabel;
    private JPanel welcomePanel;


    public LibraryApp(){
        setTitle("Library System");
        setSize(400,250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);

        setIconImage(new ImageIcon(getClass().getResource("image.jpg")).getImage());

        Container container = getContentPane();
        setLayout(new FlowLayout());

        createStudentMenu();
        createBookMenu();



        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.setBackground(Color.PINK);
        menuBar.add(studentMenu);
        menuBar.add(bookMenu);


        welcomePanel = new JPanel();
        welcomePanel.add(Box.createVerticalStrut(10));
        welcomePanel.setLayout(new BoxLayout(welcomePanel, BoxLayout.Y_AXIS));

        welcomeLabel= new JLabel("Welcome to the Library System");
        welcomeLabel.setFont(new Font("Times new Roman",3,30));
        welcomeLabel.setForeground(Color.BLACK);

        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        welcomePanel.add(welcomeLabel);
        welcomePanel.add(Box.createVerticalStrut(35));



    }
    private void setIconImage(ImageIcon imageIcon) {
    }

    public static void main(String[] args) {LibraryApp frame = new LibraryApp();}
    //when a menu item is clicked, response starts here
    public void actionPerformed(ActionEvent event) {
        String menuName;
        menuName = event.getActionCommand();

        if (menuName.equals("Quit"))
            System.exit(0);
        else
            welcomeLabel.setText("Menu Item " + menuName + " is selected");

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
