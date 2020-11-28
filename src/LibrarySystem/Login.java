package LibrarySystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends LibraryApp  {
    private JTextField usernameField;
    private JPasswordField passwordField;


    public Login(){
        JFrame Login = new JFrame("Login Admin");
        FlowLayout flowLayout = new FlowLayout();
        Login.setLayout(flowLayout);
        Login.setLocationRelativeTo(null);

        Login.setSize(400,100);

        Login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel usernameLabel = new JLabel("Username");
        Login.add(usernameLabel);
        usernameField = new JTextField(10);
        Login.add(usernameField);
        JLabel passwordLabel = new JLabel("Password");
        Login.add(passwordLabel);
        passwordField = new JPasswordField(10);
        Login.add(passwordField);

        TextFieldEventHandler handler = new TextFieldEventHandler();

        usernameField.addActionListener(handler);
        passwordField.addActionListener(handler);

        Login.setVisible(true);
    }

    public static void main(String[] args) {
        Login guiApp = new Login();
    }




    private class TextFieldEventHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getSource() == usernameField)
            {

                passwordField.requestFocus();
            }
            if(e.getSource() == passwordField)
            {

                char[] passwordCharacters = passwordField.getPassword();


                String passwordText = new String(passwordCharacters);


                if(usernameField.getText().equals("Cormac") &&
                        passwordText.equals("123")) {
                   LibraryApp app = new LibraryApp();
                   dispose();

                } else
                JOptionPane.showMessageDialog(null, "Invalid username/password " +
                        "combination", "Not authenticated", JOptionPane.INFORMATION_MESSAGE);

                }


        }

    }








}
