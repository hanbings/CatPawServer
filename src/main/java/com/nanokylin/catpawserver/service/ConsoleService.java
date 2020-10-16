package com.nanokylin.catpawserver.service;

public interface ConsoleService {
    /**
     * 初始化控制台
     * @author Hanbings
     */
    void initConsoleService();

    /**
     * 使用控制台执行指令
     * @param command 指令
     * @author Hanbings
     */
    void execute(String command);
}
