package org.example.javaDevelopmentKit.tcpConnection;

public interface TcpConnectionListener {
    void onConnection(TCPConnection tcpConnection);
    void onReceivedString(TCPConnection tcpConnection, String value);
    void onDisconnect(TCPConnection tcpConnection);
    void onException(TCPConnection tcpConnection,Exception e);
}
