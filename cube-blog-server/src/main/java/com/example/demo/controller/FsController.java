package com.example.demo.controller;

import com.example.demo.module.Result;
import com.example.demo.service.FsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/series")
public class FsController {

    @Resource
    private FsService fsService;

    /**
     * 查询全量作品（不包含剧集视频）
     */
    @GetMapping("/getAllSeries")
    public Result getAllArticle(){
        return new Result(Result.SUCCESS, "查询成功", fsService.getAllSeries());
    }

    /**
     * 根据类型查询作品（不包含剧集视频）
     */
    @GetMapping("/getSeriesByType")
    public Result getSeriesByType(@RequestParam String type){
        return new Result(Result.SUCCESS, "查询成功", fsService.getSeriesByType(type));
    }

    /**
     * 根据作品id查询其全部的剧集
     */
    @GetMapping("/getEpisodeBySeriesId")
    public Result getEpisodeBySeriesId(@RequestParam String seriesId){
        return new Result(Result.SUCCESS, "查询成功", fsService.getEpisodeBySeriesId(seriesId));
    }

    /**
     * 根据作品ID查询作品及其剧集
     */
    @GetMapping("/getSeriesById")
    public Result getSeriesById(@RequestParam String seriesId){
        return new Result(Result.SUCCESS, "查询成功", fsService.getSeriesById(seriesId));
    }
}
