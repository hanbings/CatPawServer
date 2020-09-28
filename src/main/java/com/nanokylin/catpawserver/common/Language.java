package com.nanokylin.catpawserver.common;

import java.util.HashMap;
import java.util.Map;

/**
 * 本地化语言类
 * 获取yml中的语言并且转换为Map
 * @author Hanbings
 */
public class Language {
    /**
     * 语言Map
     */
    public static Map<String, String> LanguageMap = new HashMap<>();

    /**
     * Getter and Setter
     */
    public Map<String, String> GetLanguageMap(String path){
        return LanguageMap;
    }
    public void SetLanguageMap(String language){

    }
}
