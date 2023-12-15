package org.example.javaDevelopmentKit.tcpConnection;


import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TCPConnection {
    TcpConnectionListener eventListener;
    private final Socket socket;
    private final Thread thread;
    private final BufferedWriter out;
    private final BufferedReader in;

    public TCPConnection(TcpConnectionListener eventListener, String ipAdr, int port) throws IOException {
        this(eventListener,new Socket(ipAdr,port));
    }
    public TCPConnection(TcpConnectionListener eventListener, Socket socket) throws IOException {
        this.eventListener = eventListener;
        this.socket = socket;
        this.out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream(),StandardCharsets.UTF_8));
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TCPConnection.this.eventListener.onConnection(TCPConnection.this);
                    while (!thread.isInterrupted()) {
                        String massage = in.readLine();
                        TCPConnection.this.eventListener.onReceivedString(TCPConnection.this,massage);
                    }

                } catch (IOException e) {
                    eventListener.onException(TCPConnection.this,e);
                } finally {
                    eventListener.onDisconnect(TCPConnection.this);
                }
            }
        });
        thread.start();
    }


    public synchronized void  sendMassage(String value) {
        try {
            out.write(value + "\r\n");
            out.flush();
        }catch (IOException e){
            eventListener.onException(TCPConnection.this,e);
            disconnect();
        }

    }

    public synchronized void disconnect() {
        thread.interrupt();
        try {
            socket.close();
        } catch (IOException e) {
            eventListener.onException(TCPConnection.this,e);
        }
    }

    @Override
    public String toString() {
        return "TCPConnection: " + socket.getInetAddress() + ":" + socket.getPort();
    }
}
