package com.nanokylin.catpawserver.service;

import org.java_websocket.WebSocket;

import java.util.Collection;

public interface WebSocketPoolService {
    /**
     * 通过websocket连接获取其对应的用户
     *
     * @param connect 连接
     * @author Hanbings
     */
    String getUserByWs(WebSocket connect);

    /**
     * 根据userName获取WebSocket,这是一个list,此处取第一个
     * 因为有可能多个websocket对应一个userName（但一般是只有一个，因为在close方法中，我们将失效的websocket连接去除了）
     */
    WebSocket getWsByUser(String userName);

    /**
     * 向连接池中添加连接
     *
     * @author Hanbings
     */
    void addUser(String userName, WebSocket connect);

    /**
     * 获取所有连接池中的用户，因为set是不允许重复的，所以可以得到无重复的user数组
     */
    Collection<String> getOnlineUser();

    /**
     * 移除连接池中的连接
     *
     * @param connect 连接
     * @author Hanbings
     */
    boolean removeUser(WebSocket connect);

    /**
     * 向特定的用户发送数据
     *
     * @param connect 连接
     * @param message 消息
     * @author Hanbings
     */
    void sendMessageToUser(WebSocket connect, String message);

    /**
     * 向所有的用户发送消息
     *
     * @param message 消息
     * @author Hanbings
     */
    void sendMessageToAll(String message);
}
