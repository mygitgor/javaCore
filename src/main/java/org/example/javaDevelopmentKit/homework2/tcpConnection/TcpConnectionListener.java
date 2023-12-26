package org.example.javaDevelopmentKit.homework2.tcpConnection;

public interface TcpConnectionListener {
    void onConnection(TCPConnection tcpConnection);
    void onReceivedString(TCPConnection tcpConnection, String value);
    void onDisconnect(TCPConnection tcpConnection);
    void onException(TCPConnection tcpConnection,Exception e);
}
