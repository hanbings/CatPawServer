package com.nanokylin.catpawserver.controller;

import com.nanokylin.catpawserver.common.Config;
import com.nanokylin.catpawserver.service.WebSocketPoolService;
import com.nanokylin.catpawserver.service.impl.WebSocketPoolServiceImpl;
import com.nanokylin.catpawserver.utils.JsonUtil;
import com.nanokylin.catpawserver.utils.LogUtil;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.util.Map;

public class WebSocketController extends WebSocketServer {
    private static final LogUtil log = new LogUtil();
    private static final WebSocketPoolService webSocketPoolService = new WebSocketPoolServiceImpl();

    public WebSocketController() {
    }

    public WebSocketController(InetSocketAddress address) {
        super(address);

    }

    public void initWebSocket(ThreadController threadController) {
        // 实例化WebSocket服务
        //WebSocketService webSocketService = new WebSocketServiceImpl();
        // 新建控制台线程
        Thread WebSocketThread = new WebSocketThread();
        threadController.getThreadPool().execute(WebSocketThread);
    }

    @Override
    public void onOpen(WebSocket connect, ClientHandshake handshake) {

        ///////////////////////// Test ////////////////////////////
        connect.send("== 欢迎连接CatPawServer ==");
        connect.send("Github: https://github.com/hanbings/CatPawServer");
        connect.send("===================");
        ////////////////////////////////////////////////////////////
        broadcast("新连接: " + handshake.getResourceDescriptor());
        log.info("新连接: " + connect.getRemoteSocketAddress());

    }

    @Override
    public void onClose(WebSocket connect, int code, String reason, boolean remote) {
        log.info("关闭: " + connect.getRemoteSocketAddress() + " 退出代码: " + code + " 地址信息: " + reason);
    }

    @Override
    public void onMessage(WebSocket connect, String message) {
        log.info("已收到来自主机的: " + connect.getRemoteSocketAddress() + ": " + message);
        if (message.startsWith("CATC001") && message.endsWith("E")){
            String json = message.substring(7,message.length() -1 );
            JsonUtil jsonUtil = new JsonUtil();
            Map<String,Object> jsonMap =  jsonUtil.jsonToMap(json);
            if(jsonMap.get("username").toString() != null){
                log.info("已将用户加入WebSocket连接池" + jsonMap.get("username").toString());
                userJoin(connect,jsonMap.get("username").toString());
                connect.send("已接收到协议CATC001: " + message);
            }
        }
    }

    @Override
    public void onMessage(WebSocket connect, ByteBuffer message) {
        log.info("已收到ByteBuffer来自: " + connect.getRemoteSocketAddress());
    }

    @Override
    public void onError(WebSocket connect, Exception ex) {
        log.info("连接时发生错误: " + connect.getRemoteSocketAddress() + ":" + ex);
    }

    @Override
    public void onStart() {
        log.info("WebSocket服务成功启动！");
    }

    /**
     * 去除掉失效的websocket链接
     */
    public void userLeave(WebSocket connect) {
        webSocketPoolService.removeUser(connect);
    }

    /**
     * 将websocket加入用户池
     */
    public void userJoin(WebSocket connect, String userName) {
        webSocketPoolService.addUser(userName, connect);
    }
}

class WebSocketThread extends Thread {
    private static final LogUtil log = new LogUtil();

    @Override
    public void run() {
        super.setName("WebSocketThread");
        String host = (String) Config.getConfig("ip");
        int port = (int) Config.getConfig("port");
        WebSocketServer s = new WebSocketController(new InetSocketAddress(host, port));
        s.run();
    }
}
