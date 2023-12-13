package org.example.javaDevelopmentKit;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;
import static org.example.javaDevelopmentKit.Server.chatHistory;

public class Server {
    public static final int PORT = 8081;
    public static List<String> chatHistory = new ArrayList<>();

    public static void main(String[] args) {
       try (ServerSocket serverSocket =new ServerSocket(PORT)){
           System.out.println("Server Starting...");
           while (true){
               Socket clientSocket = serverSocket.accept();
               System.out.println("Client started: "+ clientSocket.getInetAddress().getHostAddress());
               ClientHandler clientHandler = new ClientHandler(clientSocket);
               new Thread(clientHandler).start();
           }
       }catch (IOException e){
           e.printStackTrace();
       }
    }

    private static class ClientHandler implements Runnable{
        private Socket clientSocket;
        private PrintWriter writer;
        private BufferedReader reader;
        private ClientHandler[] clints;

        public ClientHandler(Socket socket){
            this.clientSocket = socket;
            try {
                this.writer = new PrintWriter(clientSocket.getOutputStream(),true);
                this.reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        @Override
        public void run() {
            try {
                for (String message : chatHistory) {
                    out.println(message);
                }
                while (true) {
                    String message = reader.readLine();
                    if (message == null) {
                        break;
                    }

                    chatHistory.add(message);

                    // Дублирование в файл
                    try (PrintWriter fileWriter = new PrintWriter(new FileWriter("chatHistory.txt",true))){
                        fileWriter.println(message);
                    }

                    // Рассылка сообщения всем подключенным клиентам
                    for(ClientHandler client: clints){
                        client.writer.println(message);
                    }
                }
            }catch (IOException e){
                e.printStackTrace();
            }finally {
                try{
                    clientSocket.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

}

