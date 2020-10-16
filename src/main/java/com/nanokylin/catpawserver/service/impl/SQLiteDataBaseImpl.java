package com.nanokylin.catpawserver.service.impl;

import com.nanokylin.catpawserver.common.Resources;
import com.nanokylin.catpawserver.service.DataBaseService;
import com.nanokylin.catpawserver.utils.LogUtil;

import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteDataBaseImpl implements DataBaseService {
    LogUtil logger = new LogUtil();

    @Override
    public void loadSQLiteJDBC(String dataBaseName) {
        try {
            Class.forName("org.sqlite.JDBC");
            Resources.SQLLiteConnection = DriverManager.getConnection("jdbc:sqlite:" + dataBaseName);
        } catch (ClassNotFoundException | SQLException e) {
            logger.error("[SQLITE][ERROR] 连接数据库发生错误");
            e.printStackTrace();
        }
        logger.info("[SQLITE][INFO] 数据库连接成功");
    }

    @Override
    public void createDatabase(String dataBaseName) {

    }
}
