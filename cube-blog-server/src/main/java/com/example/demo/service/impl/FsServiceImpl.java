package com.example.demo.service.impl;

import com.example.demo.mapper.FsMapper;
import com.example.demo.module.FsEpisodes;
import com.example.demo.module.FsSeries;
import com.example.demo.service.FsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FsServiceImpl implements FsService {

    @Resource
    private FsMapper fsMapper;

    @Override
    public List<FsSeries> getAllSeries() {
        return fsMapper.getAllSeries();
    }

    @Override
    public List<FsSeries> getSeriesByType(String type) {
        return fsMapper.getSeriesByType(type);
    }

    @Override
    public List<FsEpisodes> getEpisodeBySeriesId(String seriesId) {
        return fsMapper.getEpisodesBySeriesId(seriesId);
    }

    public List<FsSeries> getSeriesById(String seriesId) {
        return fsMapper.getSeriesById(seriesId);
    }
}