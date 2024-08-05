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

    @GetMapping("/getAllSeries")
    public Result getAllArticle(){
        return new Result(Result.SUCCESS, "查询成功", fsService.getAllSeries());
    }


    @GetMapping("/getSeriesByType")
    public Result getSeriesByType(@RequestParam String type){
        return new Result(Result.SUCCESS, "查询成功", fsService.getSeriesByType(type));
    }
}
