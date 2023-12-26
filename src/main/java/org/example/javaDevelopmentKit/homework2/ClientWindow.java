package org.example.javaDevelopmentKit.homework2;

import org.example.javaDevelopmentKit.homework2.tcpConnection.TCPConnection;
import org.example.javaDevelopmentKit.homework2.tcpConnection.TcpConnectionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ClientWindow extends JFrame implements ActionListener, TcpConnectionListener {
    public static final String IP_ADR = "127.0.0.1";
    private static final int PORT = 8080;

    public static final int WIDTH = 550;
    public static final int HEIGHT = 400;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClientWindow();
            }
        });

    }

    private final JTextArea log = new JTextArea();
    private final JTextField fieldNickName = new JTextField("gor");
    private final JTextField fieldInput = new JTextField();

    private TCPConnection connection;
    private ClientWindow(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIDTH,HEIGHT);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);

        log.setEnabled(false);
        log.setLineWrap(true);
        fieldInput.addActionListener(this);
        add(log, BorderLayout.CENTER);
        add(fieldInput,BorderLayout.SOUTH);
        add(fieldNickName,BorderLayout.NORTH);

        setVisible(true);
        try {
            connection = new TCPConnection(this,IP_ADR,PORT);
        } catch (IOException e) {
            printMessage("Connection Exception: "+e);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = fieldInput.getText();
        if(msg.equals(""))
            return;
        fieldInput.setText(null);
        connection.sendMassage(fieldNickName.getText() + ": " + msg);
    }

    @Override
    public void onConnection(TCPConnection tcpConnection) {
        printMessage("Connection Ready...");
    }

    @Override
    public void onReceivedString(TCPConnection tcpConnection, String value) {
        printMessage(value);
    }

    @Override
    public void onDisconnect(TCPConnection tcpConnection) {
        printMessage("Connection Close");
    }

    @Override
    public void onException(TCPConnection tcpConnection, Exception e) {
        printMessage("Connection Exception: "+e);
    }

    private synchronized void printMessage(String msg){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                log.append(msg + "\n");
                log.setCaretPosition(log.getDocument().getLength());
            }
        });
    }
}
