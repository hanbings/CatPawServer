package com.nanokylin.catpawserver.config;

import com.nanokylin.catpawserver.CatPawServer;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * 用于读取YAML配置文件的类
 *
 * @author Hanbings
 */
public class YAMLReader {
    public Map<String, Object> getYamlFileConvertToMap(String path) {
        Map<String, Object> map = new HashMap<>();
        try {
            Yaml yaml = new Yaml();
            URL url = CatPawServer.class.getClassLoader().getResource(path);
            if (url != null) {
                map = yaml.load(new FileInputStream(url.getFile()));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}
