package com.nanokylin.catpawserver.service.impl;

import com.nanokylin.catpawserver.common.Language;
import com.nanokylin.catpawserver.common.ThreadSetter;
import com.nanokylin.catpawserver.common.constant.BaseInfo;
import com.nanokylin.catpawserver.service.WebSocketService;
import com.nanokylin.catpawserver.utils.LogUtil;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;

public class WebSocketServiceImpl extends WebSocketServer implements WebSocketService {
    private static final LogUtil log = new LogUtil();
    public WebSocketServiceImpl(){ }
    public WebSocketServiceImpl(InetSocketAddress address) {
        super(address);
    }
    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {

        ///////////////////////// Test ////////////////////////////
        conn.send("== 欢迎连接CatPawServer ==");
        conn.send("Github: https://github.com/hanbings/CatPawServer");
        conn.send("你可以通过输入窗口与CatPawServer服务器进行对话");
        conn.send("===================");
        ////////////////////////////////////////////////////////////

        broadcast( "新连接: " + handshake.getResourceDescriptor() );
        log.info("新连接: " + conn.getRemoteSocketAddress());
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        log.info("关闭: " + conn.getRemoteSocketAddress() + " 退出代码: " + code + " 地址信息: " + reason);
    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        log.info("已收到来自主机的: "	+ conn.getRemoteSocketAddress() + ": " + message);

        ///////////////////////// Test ////////////////////////////
        if (message.contains("fuck")){
            conn.send("[CatPawServer] Fuck You NMSL");
        }
        else if(message.contains("version")){
            conn.send("[CatPawServer] " + Language.getText("cat_paw_server_version") + BaseInfo.CAT_PAW_SERVER_VERSION);
            conn.send("[CatPawServer] " + Language.getText("cat_paw_server_build_time") + BaseInfo.CAT_PAW_SERVER_BUILD_TIME);
        }
        else{
            conn.send("[CatPawServer] 还不认识这句话 不过服务器收到了消息");
        }
        ////////////////////////////////////////////////////////////
    }

    @Override
    public void onMessage( WebSocket conn, ByteBuffer message ) {
        log.info("已收到ByteBuffer来自: " + conn.getRemoteSocketAddress());
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {
        log.info("连接时发生错误: " + conn.getRemoteSocketAddress()  + ":" + ex);
    }

    @Override
    public void onStart() {
        log.info("WebSocket服务成功启动！");
    }

    @Override
    public void initWebSocketService(){
        // 新建控制台线程
        Thread WebSocketThread = new WebSocketThread();
        WebSocketThread.setName("WebSocketThread");
        // 获取线程池放入线程
        ThreadSetter threadSetter = new ThreadSetter();
        threadSetter.getThreadPool().execute(WebSocketThread);
    }
}

class WebSocketThread extends Thread{
    private static final LogUtil log = new LogUtil();
    @Override
    public void run(){
        String host = "localhost";
        int port = 10086;
        org.java_websocket.server.WebSocketServer s = new WebSocketServiceImpl(new InetSocketAddress(host, port));
        s.run();
    }
}
