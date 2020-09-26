package com.nanokylin.catpawserver.config;

import com.nanokylin.catpawserver.util.FileUtil;

/**
 * 加载服务器默认文件目录
 * @author Hanbings
 */
public class ServerConfigLoader {
    FileUtil fileUtil = new FileUtil();
    public ServerConfigLoader(){
        fileUtil.copyFileOutOfJar("config.yml","./config.yml");
    }
}
