package com.nanokylin.catpawserver.controller;

import com.nanokylin.catpawserver.common.Config;
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
        // 实例化配置类
        Config config = new Config();
        // 获取配置文件
        config.setConfigMap();
        // 实例化语言类
        Language language = new Language();
        // 设置语言
        language.setLanguageMap(Config.getConfig("language").toString());
        // 打印基本信息
        this.Info();
    }
    public void Info(){
        log.info(Language.getText("os") + BaseInfo.SYSTEM_NAME);
        log.info(Language.getText("os_version") + BaseInfo.SYSTEM_VERSION);
        log.info(Language.getText("system_arch") + BaseInfo.SYSTEM_ARCH);
        log.info(Language.getText("java_vm_version") + BaseInfo.JAVA_VM_VERSION);
        log.info(Language.getText("java_vm_vendor") + BaseInfo.JAVA_VM_VENDOR);
        log.info(Language.getText("java_vm_name") + BaseInfo.JAVA_VM_NAME);
        log.info(Language.getText("java_class_version") + BaseInfo.JAVA_CLASS_VERSION);
        log.info(Language.getText("java_class_path") + BaseInfo.JAVA_CLASS_PATH);
        log.info(Language.getText("cat_paw_server_version") + BaseInfo.CAT_PAW_SERVER_VERSION);
        log.info(Language.getText("cat_paw_server_build_time") + BaseInfo.CAT_PAW_SERVER_BUILD_TIME);
        log.info(BaseInfo.CAT_PAW_SERVER_LOGO);
    }
}
