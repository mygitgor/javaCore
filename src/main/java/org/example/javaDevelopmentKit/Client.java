package org.example.javaDevelopmentKit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class Client {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 8081;

    private static JFrame frame;
    private static JTextArea chatArea;
    private static JTextField messageField;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
            connectToServer();
        });
    }

    private static void createAndShowGUI() {
        frame = new JFrame("Chat Server");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,300);

        chatArea = new JTextArea();
        chatArea.setEnabled(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);

        messageField = new JTextField();
        messageField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(scrollPane,BorderLayout.CENTER);
        panel.add(messageField,BorderLayout.SOUTH);
        panel.add(sendButton,BorderLayout.EAST);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    private static void connectToServer() {
        try(Socket socket = new Socket(SERVER_IP,SERVER_PORT);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true)){

            // Заполнение истории чата из файла
            try(BufferedReader bufferedReader1 = new BufferedReader(new FileReader("chatHistory.txt"))){
                String line;
                while ((line = bufferedReader1.readLine()) != null){
                    chatArea.append(line+ "\n");
                }
            }

            while (true){
                String message = bufferedReader.readLine();
                if(message == null){
                    break;
                }
                chatArea.append(message + "\n");
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private static void sendMessage() {
        String message = messageField.getText();
        if(!message.isEmpty()){
            chatArea.append("you: "+ message +"\n");
            messageField.setText("");

            try(Socket socket = new Socket(SERVER_IP,SERVER_PORT);
                PrintWriter writer = new PrintWriter(socket.getOutputStream(),true)){
                writer.println(message);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
