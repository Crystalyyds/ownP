package com.example.own.utils.amap;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.example.own.utils.amap.pojo.AmapPoi;
import com.example.own.utils.amap.pojo.AmapSuggestion;
import com.example.own.utils.amap.pojo.AmapWeather;
import org.springframework.stereotype.Service;

import java.util.HashMap;


@Service
public class AmapService {
    /*
    *  申请自己的WEB key
    */
    static final String key = "a383aad888722e5462d2e2392b7614e4";

    /*
     *  POI 搜查
     */
    public static   AmapPoi PoiSearch(String keyword, String location) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("output", "JSON");
        hashMap.put("extensions", "base");
        hashMap.put("key", key);
        hashMap.put("keywords", keyword);
        hashMap.put("location", location);
        String json = HttpUtil.post("https://restapi.amap.com/v3/place/text?", hashMap);

        return JSONUtil.toBean(json, AmapPoi.class);
    }


    /*
     *  天气查询
     */

    public  AmapWeather WeatherSearch(String keyword) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("output", "JSON");
        hashMap.put("key", key);
        hashMap.put("keywords", keyword);
        String json = HttpUtil.post("https://restapi.amap.com/v3/weather/weatherInfo?", hashMap);
        return JSONUtil.toBean(json, AmapWeather.class);
    }

    /*
     *  搜索提示  建议使用location 优先返回周边
     */
    public AmapSuggestion SuggestionSearch(String keyword,String location) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("output", "JSON");
        hashMap.put("key", key);
        hashMap.put("location",location);
        hashMap.put("keywords", keyword);
        String json = HttpUtil.post("https://restapi.amap.com/v3/assistant/inputtips?",hashMap);
        return JSONUtil.toBean(json, AmapSuggestion.class);
    }

}
