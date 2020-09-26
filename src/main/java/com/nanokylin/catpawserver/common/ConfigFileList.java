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
        list.add("./lib/log4j-api-2.1.jar");
        list.add("./lib/log4j-core-2.1.jar");
        list.add("./lib/log4j-web-2.1.jar");
        list.add("./config.yml");
    }
    public ArrayList<String> getList(){
        return list;
    }
}
