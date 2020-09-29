package com.nanokylin.catpawserver.controller;

import com.nanokylin.catpawserver.common.Config;
import com.nanokylin.catpawserver.common.Resources;
import com.nanokylin.catpawserver.common.constant.BaseInfo;
import com.nanokylin.catpawserver.common.Language;
import com.nanokylin.catpawserver.utils.LogUtil;

/**
 * 给Main函数用的MainController
 * (Package) Main -> (controller) MainController -> (service) Service -> (service.impl) ServiceImpl <=> (util) Util
 * @author Hanbings
 */
public class MainController {
    private static final LogUtil log = new LogUtil();
    public void RunCatPawServer(){
        // 打印基本信息
        this.Info();
        // 实例化配置类
        Config config = new Config();
        // 获取配置文件
        config.setConfigMap();
        // 实例化语言类
        Language language = new Language();
        // 设置语言
        language.setLanguageMap(Config.getConfig("language").toString());
    }
    public void Info(){
        log.info(Language.getText("os") + BaseInfo.SYSTEM_NAME);
        log.info("操作系统版本: " + BaseInfo.SYSTEM_VERSION);
        log.info("系统构架: " + BaseInfo.SYSTEM_ARCH);
        log.info("Java版本: " + BaseInfo.JAVA_VM_VERSION);
        log.info("Java供应商: " + BaseInfo.JAVA_VM_VENDOR);
        log.info("JVM名称: " + BaseInfo.JAVA_VM_NAME);
        log.info("Class版本: " + BaseInfo.JAVA_CLASS_VERSION);
        log.info("Class路径: " + BaseInfo.JAVA_CLASS_PATH);
        log.info("CatPawServer版本: " + BaseInfo.CAT_PAW_SERVER_VERSION);
        log.info("CatPawServer构建时间: " + BaseInfo.CAT_PAW_SERVER_BUILD_TIME);
        log.info(BaseInfo.CAT_PAW_SERVER_LOGO);
    }
}
