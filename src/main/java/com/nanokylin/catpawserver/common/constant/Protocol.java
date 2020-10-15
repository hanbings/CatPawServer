package com.nanokylin.catpawserver.common.constant;

/**
 * 协议类
 * 存放协议
 */
public class Protocol {
    /////////////////// 协议数据包头 ///////////////////
    // 数据包头
    public static final String PACKAGE_HEAD = "CAT";
    // 数据包客户端标志位头
    public static final String CLIENT = "C";
    // 数据包服务端标志位头
    public static final String SERVER = "S";
    // 数据包尾
    public static final String PACKAGE_END = "E";
    //////////////////////////////////////////////////

    //////////////////////// 空 //////////////////////
    // 空
    public static final String VOID = "000";
    //////////////////////////////////////////////////

    //////////////////// 登陆部分 /////////////////////
    // 申请一个WebSocket用户池并创建用户线程
    public static final String CLIENT_LOGIN_ONE = "001";
    // 请求服务器校验密码
    public static final String CLIENT_LOGIN_TWO = "002";
    // 返回给客户端创建结果 / 若创建不成功将发回空包
    public static final String SERVER__LOGIN_ONE = "001";
    // 若登陆成功则为客户端发回第二条RSA Public Keys
    public static final String SERVER_LOGIN_TWO = "002";
    //////////////////////////////////////////////////
}
