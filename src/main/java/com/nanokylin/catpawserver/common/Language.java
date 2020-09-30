package com.nanokylin.catpawserver.common;

import com.nanokylin.catpawserver.config.YAMLReader;

import java.util.HashMap;

/**
 * 本地化语言类
 * 获取yml中的语言并且转换为Map
 * @author Hanbings
 */
public class Language {
    /**
     * 获取单句语言
     * @author Hanbings
     */
    public static Object getText(String keys){
        return Resources.LanguageMap.get(keys);
    }

    /**
     * Getter and Setter
     * @author Hanbings
     */
    public HashMap<String, Object> getLanguageMap(String path){
        return Resources.LanguageMap;
    }
    public void setLanguageMap(String language){
        YAMLReader yamlReader = new YAMLReader();
        Resources.LanguageMap = (HashMap<String, Object>) yamlReader.getYamlFileConvertToMap("./language/" + language + ".yml");
    }

}
