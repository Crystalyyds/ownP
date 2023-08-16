package com.example.own.controller;


import com.example.own.common.Result;
import com.example.own.utils.amap.AmapService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/amap")
public class AmapController {
    @Resource
    private AmapService amapService;

    /*
     *  POI 查询
     */
    @GetMapping("/poi")
    public Result getAmapPoi(@RequestParam String keyword,@RequestParam String location) {
        System.out.println("测试成功");
        return Result.success(AmapService.PoiSearch(keyword,location));
    }

    /*
     *  天气 查询  keyword => citycode
     */
    @GetMapping("/weather")
    public Result getWeather(String cityCode) {
        return Result.success(amapService.WeatherSearch(cityCode));
    }


    /*
     *  搜索提示 search
     */
    @GetMapping("/suggestion")
    public Result getWeather(String keyword, String location) {
        return Result.success(amapService.SuggestionSearch(keyword, location));
    }


}
