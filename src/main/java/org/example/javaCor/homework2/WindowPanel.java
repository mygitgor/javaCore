package org.example.javaCor.homework2;

import org.example.javaCor.homework2.ProgramExeptions.IllegalArgument;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class WindowPanel extends JFrame {
    public static final int WIDTH = 250;
    public static final int HEIGHT = 270;
    private JPanel panel;
    private JFrame frame;
    private AccountManager manager = new AccountManager();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WindowPanel();
            }
        });
    }
    private JButton loginButton;
    private JButton registerButton;
    private JTextField usernameField;
    private JTextField usersurnameField;
    private JTextField chackField;
    private JPasswordField passwordField;


    public WindowPanel(){
//-----------------------------------------------------region parameters
        super("login account");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH,HEIGHT);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);

//-----------------------------------------------------region element window
        usernameField = new JTextField(20);
        usersurnameField = new JTextField(20);
        chackField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");
        registerButton = new JButton("Register");

        panel = new JPanel();
        panel.add(new JLabel("Username: "),BorderLayout.CENTER);
        panel.add(usernameField);
        panel.add(new JLabel("User Surname: "),BorderLayout.CENTER);
        panel.add(usersurnameField);
        panel.add(new JLabel("Check: "),BorderLayout.CENTER);
        panel.add(chackField);
        panel.add(new JLabel("Password: "),BorderLayout.CENTER);
        panel.add(passwordField);
        panel.add(loginButton,BorderLayout.CENTER);
        panel.add(registerButton,BorderLayout.CENTER);

//-------------------------------------------------------region listeners
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginUser();
            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    registerUser();
                } catch (IllegalArgument ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        add(panel);
        setVisible(true);
    }
//--------------------------------------------------------------region functional
    public void loginUser(){
        String username = usernameField.getText();
        String password = String.valueOf(passwordField.getPassword());
        manager.loginUser(username, password);
    }

    public void registerUser() throws IllegalArgument {
        String username = usernameField.getText();
        String usersurname = usersurnameField.getText();
        String password = String.valueOf(passwordField.getPassword());
        double chack = Double.parseDouble(chackField.getText());
        manager.registerUser(username, usersurname, chack, password);
    }
}
