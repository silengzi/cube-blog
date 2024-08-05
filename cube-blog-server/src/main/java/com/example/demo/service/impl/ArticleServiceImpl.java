package com.example.demo.service.impl;

import com.example.demo.mapper.ArticleMapper;
import com.example.demo.module.Article;
import com.example.demo.service.ArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;

    @Override
    public List<Article> getAllArticle(String userName) {
        return articleMapper.getAllArticle(userName);
    }

    @Override
    public Article getArticleById(Long id, String userName) {
        return articleMapper.getArticleById(id, userName);
    }

    @Override
    public int updateArticle(Article article) {
        return articleMapper.updateArticle(article);
    }

    @Override
    public int createArticle(Article article) {
        return articleMapper.createArticle(article);
    }

    @Override
    public int deleteArticle(Long id, String userName) {
        return articleMapper.deleteArticle(id, userName);
    }

}