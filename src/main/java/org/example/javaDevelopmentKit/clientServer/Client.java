package org.example.javaDevelopmentKit.clientServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_IP,SERVER_PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))){
            System.out.println("Подключено к серверу. Можете писать сообщения.");

            //создание потока
            Thread receiveThread = new Thread(()->{
                try{
                    while (true){
                        String message = in.readLine();
                        if(message == null)
                            break;
                        else System.out.println("Получено от сервера: " + message);
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
            });
            receiveThread.start(); //запуск потока.

            while (true){
                String userInput = consoleReader.readLine();
                if(userInput.equalsIgnoreCase("exit")){
                    break;
                }
                out.println(userInput);
            }
            receiveThread.interrupt();//Завершение и прерывание потока


        }catch (IOException e){
            e.printStackTrace();
        }


    }


}
