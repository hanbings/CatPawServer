package com.nanokylin.catpawserver.database;

import com.nanokylin.catpawserver.database.entity.User;

public class GenerateForSQLite {
    public String generateNewUserSQL(User user) {
        String sql;
        sql = "INSERT INTO user_table (uid,email,username,password,create_time,update_time)\n" +
                "VALUES (" + user.getUID() + ", " +
                "'" + user.getEmail() + "', " +
                "'" + user.getUsername() + "', " +
                "'" + user.getPassword() + "', " +
                "'" + user.getCreateTime() + "', " +
                "'" + user.getUpdateTime() + "');";
        return sql;
    }
}
