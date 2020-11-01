package com.nanokylin.catpawserver.controller;

import com.nanokylin.catpawserver.common.Resources;
import com.nanokylin.catpawserver.service.DataBaseService;
import com.nanokylin.catpawserver.service.impl.database.SQLiteDataBaseImpl;

import java.util.Scanner;

public class DataBaseController {
    /**
     * 在这里为数据库连接开线程
     */
    public void initDatabase(ThreadController threadController) {
        Thread dataBaseThread = new DataBaseThread();
        dataBaseThread.setName("DataBaseThread");
        threadController.getThreadPool().execute(dataBaseThread);
    }
}

class DataBaseThread extends Thread {
    @Override
    public void run() {
        DataBaseService dataBaseService = new SQLiteDataBaseImpl();
        Resources.SQLLiteConnection = dataBaseService.loadDataBase("test.db");
    }
}
