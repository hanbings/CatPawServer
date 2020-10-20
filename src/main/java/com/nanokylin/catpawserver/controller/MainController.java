package com.nanokylin.catpawserver.controller;

import com.nanokylin.catpawserver.common.Resources;
import com.nanokylin.catpawserver.service.DataBaseService;
import com.nanokylin.catpawserver.service.impl.database.MySQLDataBaseImpl;
import com.nanokylin.catpawserver.utils.LogUtil;

/**
 * 给Main函数用的MainController
 * (Package) Main -> (controller) MainController -> (service) Service -> (service.impl) ServiceImpl <=> (util) Util
 *
 * @author Hanbings
 */
public class MainController {
    private static final LogUtil log = new LogUtil();

    public void RunCatPawServer() {
        // 统计启动时间
        long startTime = System.currentTimeMillis();

        // 初始化配置文件
        MixedController mixedController = new MixedController();
        mixedController.initConfiguration();
        // 打印基本信息
        mixedController.baseInfo(log);

        // 实例化线程配置器 (Package) com.nanokylin.catpawserver.common.Thread
        ThreadController threadController = new ThreadController();
        threadController.initThreadPool();

        //初始化Console
        ConsoleController consoleController = new ConsoleController();
        consoleController.initConsole(threadController);

        //初始化WebSocket
        WebSocketController webSocketController = new WebSocketController();
        webSocketController.initWebSocket(threadController);

        // 初始化数据库
        DataBaseController dataBaseController = new DataBaseController();
        dataBaseController.initDatabase(threadController);

        // 服务器启动完成
        long endTime = System.currentTimeMillis();
        log.info("Done (" + (endTime - startTime) + "ms)! For help, type help");
    }
}