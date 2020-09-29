package com.nanokylin.catpawserver.common;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 存储一部分的Static变量到这里
 */
public class Resources {
    /**
     * 配置文件Map
     */
    public static HashMap<String, Object> ConfigMap = new HashMap<>();
    /**
     * 依赖（必须）文件列表
     */
    public static ArrayList<String> DependFile = new ArrayList<>();
    /**
     * 语言Map
     */
    public static HashMap<String, Object> LanguageMap = new HashMap<>();

}
