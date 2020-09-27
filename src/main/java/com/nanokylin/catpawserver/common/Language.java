package com.nanokylin.catpawserver.common;

import java.util.HashMap;
import java.util.Map;

public class Language {
    public static Map<String, String> LanguageMap = new HashMap<>();
    public Map<String, String> GetLanguageMap(String path){
        return LanguageMap;
    }
    public void SetLanguageMap(String languagePath){

    }
}
