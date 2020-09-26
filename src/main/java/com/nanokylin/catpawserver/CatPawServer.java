package com.nanokylin.catpawserver;

import com.nanokylin.catpawserver.common.ConfigFileList;
import com.nanokylin.catpawserver.controller.MainController;
import com.nanokylin.catpawserver.util.FileUtil;

/**
 * Main Class
 * Stat of Dream
 * @author Hanbings
 */
public class CatPawServer
{
    public static void main( String[] args )
    {
        // 文件工具类
        FileUtil fileUtil = new FileUtil();
        // 实例化文件列表
        ConfigFileList configFileList = new ConfigFileList();
        // 设置配置文件列表
        configFileList.setList();
        // 加载配置文件和依赖库
        fileUtil.existsFile(configFileList.getList());
        // 实例化主控制器
        MainController mainController = new MainController();
        // 交控制权给控制器
        mainController.RunCatPawServer();
    }
}
