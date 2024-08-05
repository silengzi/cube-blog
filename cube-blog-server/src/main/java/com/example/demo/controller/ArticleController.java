package com.example.demo.controller;

import com.example.demo.dto.DeleteArticleRequest;
import com.example.demo.module.Article;
import com.example.demo.module.Result;
import com.example.demo.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @ClassName UserController
 * @Description: TODO
 * @Author JavaZhan @公众号:Java全栈架构师
 * @Date 2020/6/13
 * @Version V1.0
 **/

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;

//    @GetMapping("/getAllArticle")
//    public List<Article> getAllArticle(){
//        return articleService.getAllArticle();
//    }
    @GetMapping("/getAllArticle")
    public Result getAllArticle(@RequestParam String userName){
        return new Result(Result.SUCCESS, "查询成功", articleService.getAllArticle(userName));
    }

    @GetMapping("/getArticleById")
    public Result getArticleById(@RequestParam Long id, @RequestParam String userName){
        try {
            return new Result(Result.SUCCESS, "查询成功", articleService.getArticleById(id, userName));
        } catch (Exception e) {
            return new Result(Result.FAILURE, "查询失败，原因：" + e.getMessage());
        }
    }

    @PostMapping("/updateArticle")
    public Result updateArticle(@RequestBody Article article){
        try {
            if (article.getUserName() == null || article.getUserName().isEmpty()) {
                return new Result(Result.FAILURE, "修改失败，原因：userName 不能为空");
            }

            int result = articleService.updateArticle(article);
            if (result == 1) {
                return new Result(Result.SUCCESS, "更新成功");
            } else {
                return new Result(Result.FAILURE, "更新失败，原因：" + result);
            }
        } catch (Exception e) {
            return new Result(Result.FAILURE, "更新失败，原因：" + e.getMessage());
        }
    }

    @PostMapping("/createArticle")
    public Result createArticle(@RequestBody Article article){
        try {
            if (article.getUserName() == null || article.getUserName().isEmpty()) {
                return new Result(Result.FAILURE, "创建失败，原因：userName 不能为空");
            }

            int result = articleService.createArticle(article);
            if (result == 1) {
                return new Result(Result.SUCCESS, "创建成功");
            } else {
                return new Result(Result.FAILURE, "创建失败，原因：" + result);
            }
        } catch (Exception e) {
            return new Result(Result.FAILURE, "创建失败，原因：" + e.getMessage());
        }
    }

    @PostMapping("/deleteArticle")
    public Result deleteArticle(@RequestBody DeleteArticleRequest request){
        try {
            if (request.getUserName() == null || request.getUserName().isEmpty()) {
                return new Result(Result.FAILURE, "删除失败，原因：userName 不能为空");
            }

            Long id = request.getId();
            String userName = request.getUserName();

            articleService.deleteArticle(id, userName);
            return new Result(Result.SUCCESS, "删除成功");
        } catch (Exception e) {
            return new Result(Result.FAILURE, "删除失败，原因：" + e.getMessage());
        }
    }
}
