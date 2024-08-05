package com.example.demo.mapper;

import com.example.demo.module.FsSeries;
import java.util.List;

public interface FsMapper {
    List<FsSeries> getAllSeries(); // 查询所有作品
    List<FsSeries> getSeriesByType(String type); // 根据类型查询作品
}