package com.nanokylin.catpawserver.common;

import java.util.ArrayList;

public class DependFile {
    /**
     * Setter And Getter
     */
    public void setList(){
        // 依赖
        Resources.DependFile.add("./lib/commons-lang-2.6.jar");
        Resources.DependFile.add("./lib/log4j-api-2.1.jar");
        Resources.DependFile.add("./lib/log4j-core-2.1.jar");
        Resources.DependFile.add("./lib/log4j-web-2.1.jar");
        Resources.DependFile.add("./lib/snakeyaml-1.27.jar");
        // 语言
        Resources.DependFile.add("./language/zh_CN.yml");
        Resources.DependFile.add("./language/en_US.yml");
        // 配置文件
        Resources.DependFile.add("./config.yml");

    }
    public ArrayList<String> getList(){
        return Resources.DependFile;
    }
}
