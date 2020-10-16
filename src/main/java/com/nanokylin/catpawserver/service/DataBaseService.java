package com.nanokylin.catpawserver.service;

/**
 * 因为IDEA的图标包没有DAO的图标 所以忽略DAO包吧！
 * Happy Lazy
 */
public interface DataBaseService {
    void loadSQLiteJDBC(String dataBaseName);
    void createDatabase(String dataBaseName);
}
