package com.nanokylin.catpawserver.common;

import java.util.ArrayList;

public class ConfigFileList {
    // public static Map<String, String> map = new Map<String, String>();
    /**
     * 依赖（必须）文件列表
     * @author Hanbings
     */
    public ArrayList<String> list = new ArrayList<String>();

    /**
     * Setter And Getter
     */
    public void setList(){
        // 依赖
        list.add("./lib/log4j-api-2.1.jar");
        list.add("./lib/log4j-core-2.1.jar");
        list.add("./lib/log4j-web-2.1.jar");
        // 语言
        list.add("./language/zh_CN.yml");
        list.add("./language/en_US.yml");
        // 配置文件
        list.add("./config.yml");

    }
    public ArrayList<String> getList(){
        return list;
    }
}
