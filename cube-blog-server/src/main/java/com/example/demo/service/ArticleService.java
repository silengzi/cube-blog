package com.example.demo.service;
import com.example.demo.module.Article;

import java.util.List;

public interface ArticleService {
    List<Article> getAllArticle(String userName);

    Article getArticleById(Long id, String userName);

    int updateArticle(Article article);

    int createArticle(Article article); // 创建文章的方法

    int deleteArticle(Long id, String userName); // 删除文章的方法
}