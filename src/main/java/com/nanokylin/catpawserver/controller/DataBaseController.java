package com.nanokylin.catpawserver.controller;

import com.nanokylin.catpawserver.common.Resources;
import com.nanokylin.catpawserver.common.entity.User;
import com.nanokylin.catpawserver.service.DataBaseService;
import com.nanokylin.catpawserver.service.impl.database.SQLiteDataBaseImpl;
import com.nanokylin.catpawserver.utils.LogUtil;
import com.nanokylin.catpawserver.utils.sql.GenerateForSQLiteUtil;

import java.util.Date;
import java.util.Scanner;

public class DataBaseController {
    /**
     * 在这里为数据库连接开线程
     */
    public void initDatabase(ThreadController threadController) {
        Thread dataBaseThread = new DataBaseThread();
        threadController.getThreadPool().execute(dataBaseThread);
    }
}

class DataBaseThread extends Thread {
    private static final LogUtil log = new LogUtil();

    @Override
    public void run() {
        super.setName("DataBaseThread");
        DataBaseService dataBaseService = new SQLiteDataBaseImpl();
        Resources.SQLLiteConnection = dataBaseService.loadDataBase("test.db");

        /////////////////////////// SQL Test /////////////////////////
        GenerateForSQLiteUtil generateForSQLiteUtil = new GenerateForSQLiteUtil();
        String sql = generateForSQLiteUtil.generateNewUserSQL(
                new User(1, "3219065882@qq.com", "Hanbings",
                        "123456", new Date().toString(), new Date().toString()));
        dataBaseService.execute(Resources.SQLLiteConnection, sql);
        log.info("创建数据成功 " + sql);
        ////////////////////////////////////////////////////////////
    }
}
