package com.example.own.controller;


import com.example.own.common.Result;
import com.example.own.service.impl.AmapServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/amap")
public class AmapController {
    @Resource
    private AmapServiceImpl amapServiceImpl;

    /*
     *  POI 查询
     */
    @GetMapping("/poi")
    public Result getAmapPoi(@RequestParam String keyword,@RequestParam String location) {
        System.out.println("测试成功");
        return Result.success(AmapServiceImpl.PoiSearch(keyword,location));
    }

    /*
     *  天气 查询  keyword => citycode
     */
    @GetMapping("/weather")
    public Result getWeather(@RequestParam String cityCode) {
        return Result.success(amapServiceImpl.WeatherSearch(cityCode));
    }


    /*
     *  搜索提示 search
     */
    @GetMapping("/suggestion")
    public Result getWeather(@RequestParam String keyword, @RequestParam String location) {
        return Result.success(amapServiceImpl.SuggestionSearch(keyword, location));
    }
    /*
     *  步行路线提示，距离不能太远
     */
    @GetMapping("/go/walk")
    public Result getGoByWalking(@RequestParam String origin,@RequestParam String destination){
        System.out.println("walking==>");
        return Result.success(amapServiceImpl.WhereGoByWalking(origin, destination));
    }


}
