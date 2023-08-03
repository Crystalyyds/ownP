package com.example.own.utils.amap;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.example.own.utils.amap.pojo.PoiEntity;

import java.util.HashMap;


public class AmapService {
    public static PoiEntity PoiSearch(String keyword, String key) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("output", "JSON");
        hashMap.put("extensions", "all");
        hashMap.put("key", key);
        hashMap.put("keywords", keyword);

        String json = HttpUtil.post("https://restapi.amap.com/v3/place/text?", hashMap);

        return JSONUtil.toBean(json, PoiEntity.class);
    }
}
