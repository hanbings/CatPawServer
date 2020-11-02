package com.nanokylin.catpawserver.common.constant;

import java.util.Properties;

public class BaseInfo {
    static final Properties props = System.getProperties();
    //系统名称
    public static final String SYSTEM_NAME = props.getProperty("os.name");
    //构架类型
    public static final String SYSTEM_ARCH = props.getProperty("os.arch");
    //系统版本
    public static final String SYSTEM_VERSION = props.getProperty("os.version");
    //Java版本
    public static final String JAVA_VM_VERSION = props.getProperty("java.vm.version");
    //Java供应商
    public static final String JAVA_VM_VENDOR = props.getProperty("java.vm.vendor");
    //Java虚拟机实现名称
    public static final String JAVA_VM_NAME = props.getProperty("java.vm.name");
    //Java类格式版本号
    public static final String JAVA_CLASS_VERSION = props.getProperty("java.class.version");
    //Java类路径
    public static final String JAVA_CLASS_PATH = props.getProperty("java.class.path");
    //CatPawServer版本号
    public static final String CAT_PAW_SERVER_VERSION = "1.0.0 CAT PAW HANG (Bate)";
    //CatPawServer构建时间
    public static final String CAT_PAW_SERVER_BUILD_TIME = "2020/11/02 SAT Hanbings 3219065882@qq.com";
    //LOGO
    public static final String CAT_PAW_SERVER_LOGO =
            "                                                           \n" +
                    "_________         __ __________                            \n" +
                    "\\_   ___ \\_____ _/  |\\______   \\_____ __  _  __        \n" +
                    "/    \\  \\/\\__  \\\\   __\\     ___/\\__  \\\\ \\/ \\/ / \n" +
                    "\\     \\____/ __ \\|  | |    |     / __ \\\\     /        \n" +
                    " \\______  (____  /__| |____|    (____  /\\/\\_/           \n" +
                    "        \\/     \\/                    \\/                   ";
}

