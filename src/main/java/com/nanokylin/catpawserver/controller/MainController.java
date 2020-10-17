package com.nanokylin.catpawserver.controller;

import com.nanokylin.catpawserver.common.Config;
import com.nanokylin.catpawserver.common.Resources;
import com.nanokylin.catpawserver.common.ThreadSetter;
import com.nanokylin.catpawserver.common.constant.BaseInfo;
import com.nanokylin.catpawserver.common.Language;
import com.nanokylin.catpawserver.service.ConsoleService;
import com.nanokylin.catpawserver.service.DataBaseService;
import com.nanokylin.catpawserver.service.WebSocketService;
import com.nanokylin.catpawserver.service.impl.ConsoleServiceImpl;
import com.nanokylin.catpawserver.service.impl.database.MySQLDataBaseImpl;
import com.nanokylin.catpawserver.service.impl.database.SQLiteDataBaseImpl;
import com.nanokylin.catpawserver.service.impl.WebSocketServiceImpl;
import com.nanokylin.catpawserver.utils.LogUtil;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 给Main函数用的MainController
 * (Package) Main -> (controller) MainController -> (service) Service -> (service.impl) ServiceImpl <=> (util) Util
 * @author Hanbings
 */
public class MainController {
    private static final LogUtil log = new LogUtil();
    public void RunCatPawServer(){
        // 统计启动时间
        long startTime = System.currentTimeMillis();
        // 实例化配置类
        Config config = new Config();
        // 获取配置文件
        config.setConfigMap();
        // 实例化语言类
        Language language = new Language();
        // 设置语言
        language.setLanguageMap(Config.getConfig("language").toString());
        // 打印基本信息
        this.Info();
        // 实例化线程配置器 (Package) com.nanokylin.catpawserver.common.Thread
        ThreadSetter threadSetter = new ThreadSetter();
        // 设置线程
        threadSetter.setThread((int) Config.getConfig("corePoolSize"),(int) Config.getConfig("maximumPoolSize"),
                Config.getLong("keepAliveTime"), TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>((int) Config.getConfig("queue")));
        // 启动线程池服务
        threadSetter.setThreadPool();
        // 实例化命令行服务
        ConsoleService consoleService = new ConsoleServiceImpl();
        // 初始化命令行
        consoleService.initConsoleService();
        // 实例化WebSocket服务
        WebSocketService webSocketService = new WebSocketServiceImpl();
        // 初始化WebSocket
        webSocketService.initWebSocketService();
        // 初始化SQLITE
        DataBaseService dataBaseService = new MySQLDataBaseImpl();
        Resources.MySQLConnection = dataBaseService.loadDateBase("才不会给你看！","没有的！","别想看！");
        //////////////////////////// TEST ////////////////////////////////
        String sql = "CREATE TABLE COMPANY " +
                "(ID INT PRIMARY KEY     NOT NULL," +
                " NAME           TEXT    NOT NULL, " +
                " AGE            INT     NOT NULL, " +
                " ADDRESS        CHAR(50), " +
                " SALARY         REAL)";
        /////////////////////////////////////////////////////////////////
        dataBaseService.execute(Resources.MySQLConnection,sql);

        // 服务器启动完成
        long endTime = System.currentTimeMillis();
        log.info("Done (" + (endTime - startTime ) + "ms)! For help, type help");
    }
    public void Info(){
        log.info(Language.getText("os") + BaseInfo.SYSTEM_NAME);
        log.info(Language.getText("os_version") + BaseInfo.SYSTEM_VERSION);
        log.info(Language.getText("system_arch") + BaseInfo.SYSTEM_ARCH);
        log.info(Language.getText("java_vm_version") + BaseInfo.JAVA_VM_VERSION);
        log.info(Language.getText("java_vm_vendor") + BaseInfo.JAVA_VM_VENDOR);
        log.info(Language.getText("java_vm_name") + BaseInfo.JAVA_VM_NAME);
        log.info(Language.getText("java_class_version") + BaseInfo.JAVA_CLASS_VERSION);
        log.info(Language.getText("java_class_path") + BaseInfo.JAVA_CLASS_PATH);
        log.info(Language.getText("cat_paw_server_version") + BaseInfo.CAT_PAW_SERVER_VERSION);
        log.info(Language.getText("cat_paw_server_build_time") + BaseInfo.CAT_PAW_SERVER_BUILD_TIME);
        log.info(BaseInfo.CAT_PAW_SERVER_LOGO);
    }

}