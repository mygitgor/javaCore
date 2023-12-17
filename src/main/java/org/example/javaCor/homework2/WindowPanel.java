package org.example.javaCor.homework2;

import org.example.javaCor.homework2.ProgramExeptions.IllegalArgument;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class WindowPanel extends JFrame implements ActionListener {
    public static final int WIDTH = 550;
    public static final int HEIGHT = 350;
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
        frame = new JFrame();
        panel = new JPanel();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(WIDTH,HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setAlwaysOnTop(true);
        panel = new JPanel();

        usernameField = new JTextField(20);
        usersurnameField = new JTextField(20);
        chackField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");
        registerButton = new JButton("Register");

        JPanel panel = new JPanel();
        panel.add(new JLabel("Username: "));
        panel.add(usernameField);
        panel.add(new JLabel("User Surname: "));
        panel.add(usersurnameField);
        panel.add(new JLabel("Check: "));
        panel.add(chackField);
        panel.add(new JLabel("Password: "));
        panel.add(passwordField);
        panel.add(loginButton,BorderLayout.SOUTH);
        panel.add(registerButton,BorderLayout.SOUTH);

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
        add(panel,BorderLayout.CENTER);
        setVisible(true);
    }

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


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
