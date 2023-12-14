package org.example.javaDevelopmentKit.clientServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private static final int PORT = 8080;
    private static List<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) {

        try(ServerSocket serverSocket = new ServerSocket(PORT)){ //создание сокета и слушание порта 8080
            System.out.println("Сервер запущен. Ожидание подключения...");

            while (true){
                Socket clientSocket = serverSocket.accept(); //принятия входящего запроса к сокету.
                System.out.println("Клиент подключен: " + clientSocket.getInetAddress().getHostAddress());
                ClientHandler clientHandler = new ClientHandler(clientSocket);//создаем способ общения и передаем запрос
                clients.add(clientHandler);
                new Thread(clientHandler).start();//создаем поток для клиента и подклучаем
            }

        }catch (IOException e){
            e.printStackTrace();
        }


    }


    private static class ClientHandler implements Runnable{
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;

        public ClientHandler(Socket socket){
            this.clientSocket = socket;
            try {
                this.out = new PrintWriter(clientSocket.getOutputStream(),true);
                this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try{
                while (true){
                    String massage = in.readLine();
                    if(massage == null)
                        break;
                    System.out.println("Получено от " + clientSocket.getInetAddress().getHostAddress()
                            + ": " + massage);

                    // Рассылка сообщения всем подключенным клиентам
                    for(ClientHandler client : clients){
                        if(client != this)
                            client.out.println(massage);
                    }
                }
            }catch (IOException e){
                e.printStackTrace();
            }finally {
                try{
                    clientSocket.close();
                    clients.remove(this);
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
