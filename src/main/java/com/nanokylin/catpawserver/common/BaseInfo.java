package com.nanokylin.catpawserver.common;

import java.util.Properties;

public class BaseInfo {
    static Properties props=System.getProperties();
    //系统名称
    public static String SYSTEM_NAME = props.getProperty("os.name");
    //构架类型
    public static String SYSTEM_ARCH = props.getProperty("os.arch");
    //系统版本
    public static String SYSTEM_VERSION = props.getProperty("os.version");
    //Java版本
    public static String JAVA_VM_VERSION = props.getProperty("java.vm.version");
    //Java供应商
    public static String JAVA_VM_VENDOR = props.getProperty("java.vm.vendor");
    //Java虚拟机实现名称
    public static String JAVA_VM_NAME = props.getProperty("java.vm.name");
    //Java类格式版本号
    public static String JAVA_CLASS_VERSION = props.getProperty("java.class.version");
    //Java类路径
    public static String JAVA_CLASS_PATH = props.getProperty("java.class.path");
    //CatPawServer版本号
    public static String CAT_PAW_SERVER_VERSION = "1.0.0 CAT PAW HANG";
    //CatPawServer构建时间
    public static String CAT_PAW_SERVER_BUILD_TIME = "2020/09/19 SAT Hanbings 3219065882@qq.com";
    //LOGO
    public static String CAT_PAW_SERVER_LOGO =
            "                                                           \n" +
            "_________         __ __________                            \n" +
            "\\_   ___ \\_____ _/  |\\______   \\_____ __  _  __        \n" +
            "/    \\  \\/\\__  \\\\   __\\     ___/\\__  \\\\ \\/ \\/ / \n" +
            "\\     \\____/ __ \\|  | |    |     / __ \\\\     /        \n" +
            " \\______  (____  /__| |____|    (____  /\\/\\_/           \n" +
            "        \\/     \\/                    \\/                   ";
}

