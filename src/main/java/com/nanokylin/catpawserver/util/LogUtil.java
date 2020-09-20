package com.nanokylin.catpawserver.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 日志类
 * Log Class
 * @author Hanbings
 */
public class LogUtil {
    Logger logger;

    /**
     * 提供一个无参构造方法
     * @author Hanbings
     */
    public LogUtil(){
        logger = LogManager.getLogger(LogUtil.class.getName());
    }
    /**
     * 提供一个有参构造方法
     * @author Hanbings
     */
    public LogUtil(Class<?> clazz){
        logger = LogManager.getLogger(clazz);
    }

    /**
     * INFO消息
     * @param message 消息
     * @author Hanbings
     */
    public void info(String message){
        logger.info(message);
    }
    /**
     * WARN消息
     * @param message 消息
     * @author Hanbings
     */
    public void warn(String message){
        logger.warn(message);
    }
    /**
     * DEBUG消息
     * @param message 消息
     * @author Hanbings
     */
    public void debug(String message){
        logger.debug(message);
    }
    /**
     * ERROR消息
     * @param message 消息
     * @author Hanbings
     */
    public void error(String message){
        logger.error(message);
    }
    /**
     * FATAL消息
     * @param message 消息
     * @author Hanbings
     */
    public void fatal(String message){
        logger.fatal(message);
    }

}
