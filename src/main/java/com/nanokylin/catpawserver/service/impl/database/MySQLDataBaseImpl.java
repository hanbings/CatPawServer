package com.nanokylin.catpawserver.service.impl.database;

import com.nanokylin.catpawserver.service.DataBaseService;
import com.nanokylin.catpawserver.utils.LogUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLDataBaseImpl implements DataBaseService {
    @Override
    public Connection loadDataBase(String dataBaseName) {
        return null;
    }

    @Override
    public Connection loadDateBase(String dataBaseURL, String username, String password) {
        LogUtil log = new LogUtil();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(dataBaseURL, username, password);
            log.info("[MYSQL][INFO] 数据库加载成功");
            return connection;
        } catch (ClassNotFoundException e) {
            log.error("[MYSQL][ERROR] 安装的MySQL版本号高于8.0 正在尝试加载8.0以上兼容的JDBC");
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection(dataBaseURL, username, password);
                log.info("[MYSQL][INFO] 数据库加载成功");
                return connection;
            } catch (ClassNotFoundException | SQLException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
        } catch (SQLException e) {
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
