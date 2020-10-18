package com.nanokylin.catpawserver.service.impl;

import com.nanokylin.catpawserver.common.Config;
import com.nanokylin.catpawserver.common.Language;
import com.nanokylin.catpawserver.common.constant.BaseInfo;
import com.nanokylin.catpawserver.service.ThreadPoolService;
import com.nanokylin.catpawserver.service.WebSocketPoolService;
import com.nanokylin.catpawserver.service.WebSocketService;
import com.nanokylin.catpawserver.utils.LogUtil;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;

public class WebSocketServiceImpl extends WebSocketServer implements WebSocketService {
    private static final LogUtil log = new LogUtil();
    private static final WebSocketPoolService webSocketPoolService = new WebSocketPoolServiceImpl();
    public WebSocketServiceImpl(){ }
    public WebSocketServiceImpl(InetSocketAddress address) {
        super(address);
    }
    @Override
    public void onOpen(WebSocket connect, ClientHandshake handshake) {

        ///////////////////////// Test ////////////////////////////
        connect.send("== 欢迎连接CatPawServer ==");
        connect.send("Github: https://github.com/hanbings/CatPawServer");
        connect.send("你可以通过输入窗口与CatPawServer服务器进行对话");
        connect.send("===================");
        ////////////////////////////////////////////////////////////

        broadcast( "新连接: " + handshake.getResourceDescriptor() );
        log.info("新连接: " + connect.getRemoteSocketAddress());
    }

    @Override
    public void onClose(WebSocket connect, int code, String reason, boolean remote) {
        log.info("关闭: " + connect.getRemoteSocketAddress() + " 退出代码: " + code + " 地址信息: " + reason);
        userLeave(connect);
    }

    @Override
    public void onMessage(WebSocket connect, String message) {
        log.info("已收到来自主机的: "	+ connect.getRemoteSocketAddress() + ": " + message);
        ///////////////////////// Test ////////////////////////////
        if (message.contains("fuck")){
            connect.send("[CatPawServer] Fuck You NMSL");
        }
        else if(message.contains("version")){
            connect.send("[CatPawServer] " + Language.getText("cat_paw_server_version") + BaseInfo.CAT_PAW_SERVER_VERSION);
            connect.send("[CatPawServer] " + Language.getText("cat_paw_server_build_time") + BaseInfo.CAT_PAW_SERVER_BUILD_TIME);
        }
        else if (message.startsWith("join")){
            String userName=message.replaceFirst("join", message);//用户名
            userJoin(connect,userName);//用户加入
            webSocketPoolService.sendMessageToAll("[CatPawServer] " + userName + "加入了服务器");
        }
        else if (message.startsWith("exit")){
            userLeave(connect);
        }
        else{
            connect.send("[CatPawServer] 还不认识这句话 不过服务器收到了消息");
        }
        ////////////////////////////////////////////////////////////
    }

    @Override
    public void onMessage( WebSocket connect, ByteBuffer message ) {
        log.info("已收到ByteBuffer来自: " + connect.getRemoteSocketAddress());
    }

    @Override
    public void onError(WebSocket connect, Exception ex) {
        log.info("连接时发生错误: " + connect.getRemoteSocketAddress()  + ":" + ex);
    }

    @Override
    public void onStart() {
        log.info("WebSocket服务成功启动！");
    }

    /**
     * 去除掉失效的websocket链接
     */
    public void userLeave(WebSocket connect){
        webSocketPoolService.removeUser(connect);
    }
    /**
     * 将websocket加入用户池
     */
    public void userJoin(WebSocket connect,String userName){
        webSocketPoolService.addUser(userName, connect);
    }

    @Override
    public void initWebSocketService(ThreadPoolService threadPoolService){
        // 新建控制台线程
        Thread WebSocketThread = new WebSocketThread();
        WebSocketThread.setName("WebSocketThread");
        threadPoolService.execute(WebSocketThread);
    }
}

class WebSocketThread extends Thread{
    private static final LogUtil log = new LogUtil();
    @Override
    public void run(){
        String host = (String) Config.getConfig("ip");
        int port = (int) Config.getConfig("port");
        org.java_websocket.server.WebSocketServer s = new WebSocketServiceImpl(new InetSocketAddress(host, port));
        s.run();
    }
}
