package com.nanokylin.catpawserver.controller;

import com.nanokylin.catpawserver.common.Config;
import com.nanokylin.catpawserver.common.ThreadSetter;
import com.nanokylin.catpawserver.common.constant.BaseInfo;
import com.nanokylin.catpawserver.common.Language;
import com.nanokylin.catpawserver.service.ThreadPoolService;
import com.nanokylin.catpawserver.service.impl.ThreadPoolServiceImpl;
import com.nanokylin.catpawserver.utils.LogUtil;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

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
        // 实例化线程配置器 (Package) com.nanokylin.catpawserver.common.Thread
        ThreadSetter threadSetter = new ThreadSetter();
        // 设置线程
        threadSetter.setThread((int) Config.getConfig("corePoolSize"),(int) Config.getConfig("maximumPoolSize"),
                Config.getLong("keepAliveTime"), TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>((int) Config.getConfig("queue")),
                Config.getConfig("threadNameFormat").toString());
        ThreadPoolService threadPoolService = new ThreadPoolServiceImpl();
        threadPoolService.initThread();

        //////////////////// Thread Test /////////////////////////
        java.lang.Thread t1 = new MyThread();
        java.lang.Thread t2 = new MyThread();
        java.lang.Thread t3 = new MyThread();
        java.lang.Thread t4 = new MyThread();
        java.lang.Thread t5 = new MyThread();
        threadPoolService.execute(t1);
        threadPoolService.execute(t2);
        threadPoolService.execute(t3);
        threadPoolService.execute(t4);
        threadPoolService.execute(t5);
        //////////////////////////////////////////////////////////

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
class MyThread extends java.lang.Thread {
    private static final LogUtil log = new LogUtil();
    @Override
    public void run() {
        for (;;){
            log.info(java.lang.Thread.currentThread().getName() + "正在执行...");
        }
    }
}
