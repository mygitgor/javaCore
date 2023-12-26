package org.example.javaDevelopmentKit.homework2;

import org.example.javaDevelopmentKit.homework2.tcpConnection.TCPConnection;
import org.example.javaDevelopmentKit.homework2.tcpConnection.TcpConnectionListener;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer implements TcpConnectionListener {
    private static final int PORT = 8080;
    private static List<TCPConnection> connections = new ArrayList<>();

    public static void main(String[] args) {
        new ChatServer();


    }

    private ChatServer(){
        try(ServerSocket serverSocket = new ServerSocket(PORT)){
            System.out.println("Сервер запущен. Ожидание подключения...");
            while (true){
                try{
                   new TCPConnection(this,serverSocket.accept());
                }catch (IOException e){
                    System.out.println("TCPConnection exception:" +e);
                }
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }


    @Override
    public synchronized void onConnection(TCPConnection tcpConnection) {
        connections.add(tcpConnection);
        sendToAllConnection("Client Connected: "+tcpConnection);
    }

    @Override
    public synchronized void onReceivedString(TCPConnection tcpConnection, String value) {
        sendToAllConnection(value);
    }

    @Override
    public synchronized void onDisconnect(TCPConnection tcpConnection) {
        connections.remove(tcpConnection);
        sendToAllConnection("Client Disconnect: "+tcpConnection);
    }

    @Override
    public synchronized void onException(TCPConnection tcpConnection, Exception e) {
        System.out.println("TCPConnection Exception: "+ e);
    }

    private void sendToAllConnection(String value){
        System.out.println(value);
        final int count = connections.size();
        for (int i = 0; i < count; i++) {
            connections.get(i).sendMassage(value);
        }
    }
}
