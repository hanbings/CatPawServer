package com.nanokylin.catpawserver.service.impl;

import com.nanokylin.catpawserver.common.Resources;
import com.nanokylin.catpawserver.service.WebSocketPoolService;
import org.java_websocket.WebSocket;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class WebSocketPoolServiceImpl implements WebSocketPoolService {

    @Override
    public String getUserByWebSocket(WebSocket connect) {
        return Resources.WebSocketUserMap.get(connect);
    }

    @Override
    public WebSocket getWebSocketByUser(String userName) {
        Set<WebSocket> keySet = Resources.WebSocketUserMap.keySet();
        synchronized (keySet) {
            for (WebSocket connect : keySet) {
                String cuser = Resources.WebSocketUserMap.get(connect);
                if (cuser.equals(userName)) {
                    return connect;
                }
            }
        }
        return null;
    }

    @Override
    public void addUser(String userName, WebSocket connect) {
        Resources.WebSocketUserMap.put(connect, userName);
    }

    @Override
    public Collection<String> getOnlineUser() {
        Collection<String> setUser = Resources.WebSocketUserMap.values();
        return new ArrayList<String>(setUser);
    }

    @Override
    public boolean removeUser(WebSocket connect) {
        if (Resources.WebSocketUserMap.containsKey(connect)) {
            Resources.WebSocketUserMap.remove(connect); // 移除连接
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void sendMessageToUser(WebSocket connect, String message) {
        if (null != connect && null != Resources.WebSocketUserMap.get(connect)) {
            connect.send(message);
        }
    }

    @Override
    public void sendMessageToAll(String message) {
        Set<WebSocket> keySet = Resources.WebSocketUserMap.keySet();
        synchronized (keySet) {
            for (WebSocket connect : keySet) {
                String user = Resources.WebSocketUserMap.get(connect);
                if (user != null) {
                    connect.send(message);
                }
            }
        }
    }
}
