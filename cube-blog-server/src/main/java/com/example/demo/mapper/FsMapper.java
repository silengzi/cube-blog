package com.example.demo.mapper;

import com.example.demo.module.FsEpisodes;
import com.example.demo.module.FsSeries;
import java.util.List;

public interface FsMapper {
    List<FsSeries> getAllSeries(); // 查询所有作品
    List<FsSeries> getSeriesByType(String type); // 根据类型查询作品
    List<FsEpisodes> getEpisodesBySeriesId(String seriesId); // 根据作品id查询其全部的剧集
    List<FsSeries> getSeriesById(String seriesId); // 根据作品ID查询作品及其剧集
}