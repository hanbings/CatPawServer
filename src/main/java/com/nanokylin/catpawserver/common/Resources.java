package com.nanokylin.catpawserver.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * 存储一部分的Static变量到这里
 */
public class Resources {
    // ################ List ################ //
    // 文件列表
    public static ArrayList<String> DependFile = new ArrayList<>();

    // ################ Map ################ //
    // 配置文件Map
    public static HashMap<String, Object> ConfigMap = new HashMap<>();
    // 语言Map
    public static HashMap<String, Object> LanguageMap = new HashMap<>();
}
