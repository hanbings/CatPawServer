package com.nanokylin.catpawserver.service.impl;

import com.nanokylin.catpawserver.service.WebSocketService;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.Set;

public class WebSocketServiceImpl extends WebSocketServer implements WebSocketService {

    public WebSocketServiceImpl(int port) throws UnknownHostException {
        super(new InetSocketAddress(InetAddress.getLocalHost(), port));
    }


    public WebSocketServiceImpl(InetSocketAddress address) {
        super(address);
    }

    @Override
    public void onOpen(WebSocket webSocket, ClientHandshake clientHandshake) {
        sendToAll("new");

        System.out.println(webSocket + "entered the room!");
    }

    @Override
    public void onClose(WebSocket webSocket, int n, String str, boolean bool) {
        sendToAll(webSocket + "has left the room!");
        System.out.println( webSocket + " has left the room!" );
    }

    @Override
    public void onMessage(WebSocket webSocket, String message) {
        sendToAll(message);
        System.out.println("========="+message+"=========");
        System.out.println( webSocket + ": " + message );
    }

    @Override
    public void onError(WebSocket webSocket, Exception e) {
        e.printStackTrace();
    }

    public void sendToAll(String text){
        Set<WebSocket> con = (Set<WebSocket>) connections();
        synchronized (con) {
            for(WebSocket c : con){
                c.send(text);
            }
        }
    }
}
