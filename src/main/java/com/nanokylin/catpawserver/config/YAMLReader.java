package com.nanokylin.catpawserver.config;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

/**
 * 用于读取YAML配置文件的类
 *
 * @author Hanbings
 */
public class YAMLReader {
    /**
     * 获取YAML文件转换成 Map<String, String>
     * @param path YAML路径
     * @return Map<String, String>
     */
    public Map<String, Object> getYamlFileConvertToMap(String path) {
        Map map = new HashMap<String,Object>();
        Yaml yaml = new Yaml();
        File ymlFile = new File(path);
        if (ymlFile.exists()) {
            try {
                map = yaml.load(new FileInputStream(ymlFile));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return map;
    }
}
