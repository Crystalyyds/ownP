package com.example.own.utils.amap;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.example.own.utils.amap.pojo.AmapWeather;
import com.example.own.utils.amap.pojo.AmapPoi;
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
    public  AmapPoi PoiSearch(String keyword) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("output", "JSON");
        hashMap.put("extensions", "all");
        hashMap.put("key", key);
        hashMap.put("keywords", keyword);

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

}
