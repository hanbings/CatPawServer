package com.nanokylin.catpawserver.service.impl;

import com.nanokylin.catpawserver.service.DataBaseService;
import com.nanokylin.catpawserver.utils.LogUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteDataBaseImpl implements DataBaseService {
    LogUtil log = new LogUtil();
    @Override
    public Connection loadDatabase(String dataBaseName) {
        Connection connection;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + dataBaseName);
            log.info("[SQLITE][INFO] 数据库加载成功");
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            log.error("[SQLITE][ERROR] 连接数据库发生错误");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void execute(Connection connection, String sql) {
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
            connection.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

}
