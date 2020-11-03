package com.nanokylin.catpawserver.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.Map;

public class JsonUtil {
    /**
     * 使用GSON快速将JSON转换为MAP 有问题再修吧（
     * 毕竟Happy Lazy
     * @param json JSON字符串
     * @return 转换后的 Map<String,Object>
     */
    public Map<String,Object> jsonToMap(String json){
        return new Gson().fromJson(json, new TypeToken<HashMap<String,Object>>(){}.getType());
    }
}
