package com.example.demo.mapper;
import com.example.demo.module.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleMapper  {
    List<Article>  getAllArticle(String userName);
    Article getArticleById(@Param("id") Long id, @Param("userName") String userName);
    int updateArticle(Article article); // 修改文章的方法
    int createArticle(Article article); // 创建文章的方法
    int deleteArticle(@Param("id") Long id, @Param("userName") String userName); // 删除文章的方法
}