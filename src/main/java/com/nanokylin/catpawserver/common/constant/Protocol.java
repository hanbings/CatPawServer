package com.nanokylin.catpawserver.common.constant;

/**
 * 协议类
 * 存放协议
 */
public class Protocol {
    /**
     * 连接头
     * [CATHEAD~]
     * 标准连接头 [CATHEAD~] [USERNAME]
     */
    public static String CONNECT_HEAD = "CATHEAD~";
    /**
     * 链接尾
     * [CATTAIL~]
     * 标准连接尾 [CATTAIL~] [USERNAME]
     */
    public static String CONNECT_TAIL = "CATTAIL~";
}
