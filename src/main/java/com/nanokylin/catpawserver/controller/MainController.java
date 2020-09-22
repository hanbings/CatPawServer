package com.nanokylin.catpawserver.controller;

import com.nanokylin.catpawserver.common.BaseInfo;
import com.nanokylin.catpawserver.service.ConsoleService;
import com.nanokylin.catpawserver.util.LogUtil;

public class MainController {
    public void RunCatPawServer(){
        LogUtil log = new LogUtil();
        ConsoleService consoleService = new ConsoleService();
        log.info("操作系统: " + BaseInfo.SYSTEM_NAME + " " + BaseInfo.SYSTEM_VERSION);
        log.info("系统构架: " + BaseInfo.SYSTEM_ARCH);
        log.info("Java版本: " + BaseInfo.JAVA_VM_VERSION);
        log.info("Java供应商: " + BaseInfo.JAVA_VM_VENDOR);
        log.info("JVM名称: " + BaseInfo.JAVA_VM_NAME);
        log.info("Class版本: " + BaseInfo.JAVA_CLASS_VERSION);
        log.info("Class路径: " + BaseInfo.JAVA_CLASS_PATH);
        log.info("CatPawServer版本: " + BaseInfo.CAT_PAW_SERVER_VERSION);
        log.info("CatPawServer构建时间: " + BaseInfo.CAT_PAW_SERVER_BUILD_TIME);
        log.info(BaseInfo.CAT_PAW_SERVER_LOGO);
        consoleService.RunConsole();
    }
}
