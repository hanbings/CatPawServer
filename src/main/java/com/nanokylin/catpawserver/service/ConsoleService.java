package com.nanokylin.catpawserver.service;

import com.nanokylin.catpawserver.util.LogUtil;

public class ConsoleService {
    public void RunConsole(){
        LogUtil log = new LogUtil(this.getClass());
        log.info("加载控制台服务...");
    }
}
