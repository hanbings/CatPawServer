package com.nanokylin.catpawserver.common;

import com.nanokylin.catpawserver.config.YAMLReader;

import java.util.HashMap;

public class Config {
    /**
     * Setter and Getter
     */
    public void setConfigMap() {
        YAMLReader yamlReader = new YAMLReader();
        Resources.ConfigMap = (HashMap<String, Object>) yamlReader.getYamlFileConvertToMap("./config.yml");
    }

    public HashMap<String, Object> getConfigMap() {
        return Resources.ConfigMap;
    }

    /**
     * 获取单句配置文件
     */
    public static Object getConfig(String keys) {
        return Resources.ConfigMap.get(keys);
    }

    public static long getLong(String keys) {
        return ((Number) Resources.ConfigMap.get(keys)).longValue();
    }
}
