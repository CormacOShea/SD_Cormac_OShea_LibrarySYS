package LibrarySystem;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LibraryApp extends JFrame implements ActionListener {
    private JMenu studentMenu;
    private JMenu bookMenu;
    private JMenu loanedMenu;
    private JLabel imgLabel;
    private JLabel welcomeLabel;


    public LibraryApp(){
        setTitle("Library System");
        setSize(400,250);
        setLocationRelativeTo(null);
        setResizable(true);

        setIconImage(new ImageIcon(getClass().getResource("image.jpg")));
    }

    private void setIconImage(ImageIcon imageIcon) {
    }


    public void actionPerformed(ActionEvent e) {

    }
}
