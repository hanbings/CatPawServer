package com.nanokylin.catpawserver.service.impl.database;

import com.nanokylin.catpawserver.service.DataBaseService;

import java.sql.Connection;

public class MySQLDataBaseImpl implements DataBaseService {
    @Override
    public Connection loadDatabase(String dataBaseName) {
        return null;
    }

    @Override
    public void execute(Connection connection, String sql) {

    }
}
