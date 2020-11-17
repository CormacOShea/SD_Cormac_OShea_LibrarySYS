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
    private JPanel wlcPanel;


    public LibraryApp(){
        setTitle("Library System");
        setSize(400,250);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setIconImage(new ImageIcon(getClass().getResource("book.png")).getImage());

        Container cpane = this.getContentPane();
       cpane.setLayout(new GridBagLayout());

        createStudentMenu();
        createBookMenu();



        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.setBackground(Color.PINK);
        menuBar.add(studentMenu);
        menuBar.add(bookMenu);

        welcomeLabel = new JLabel("Menu Tester");
        add(welcomeLabel);

        this.wlcPanel = new JPanel();
        this.wlcPanel.add(Box.createVerticalStrut(10));
        this.wlcPanel.setLayout(new BoxLayout(this.wlcPanel, 1));
        this.welcomeLabel = new JLabel("Welcome to the System");
        this.welcomeLabel.setFont(new Font("serif", 3, 20));
        this.welcomeLabel.setForeground(Color.BLUE);
        this.welcomeLabel.setAlignmentX(0.5F);
        this.wlcPanel.add(this.welcomeLabel);
        this.wlcPanel.add(Box.createVerticalStrut(35));

        try {
            System.out.println(this.getClass().getResource("owl.png"));
            this.imgLabel = new JLabel();
            this.imgLabel.setIcon(new ImageIcon(this.getClass().getResource("owl.png")));
            this.imgLabel.setAlignmentX(0.5F);
            this.wlcPanel.add(this.imgLabel);
        } catch (Exception var4) {
            JOptionPane.showMessageDialog((Component)null, "Invalid Image File in Main Screen");
        }




    }

    public static void main(String[] args) {LibraryApp app = new LibraryApp();}
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
