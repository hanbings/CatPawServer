package com.nanokylin.catpawserver.utils.sql;

import com.nanokylin.catpawserver.common.entity.User;

public class GenerateForSQLiteUtil {
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
