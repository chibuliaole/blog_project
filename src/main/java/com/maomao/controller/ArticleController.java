package com.maomao.controller;

import com.maomao.pojo.Article;
import com.maomao.service.ArticleService;
import com.maomao.util.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/article")
@Tag(name = "文章管理")
public class ArticleController {

    @Autowired
    private ArticleService articleService;


    @GetMapping("getAll")
    public List<Article> getAll(){
        return articleService.getAll();
    }

    @Operation(summary = "查询列表")
    @PostMapping("queryList")
    public Result queryList(@RequestBody(required = false) Article article){
        List<Article> articleList = articleService.queryList(article);
        return Result.ok(articleList);
    }

    @Operation(summary = "增加文章")
    @PostMapping("/addArticle")
    public Result addArticle(@RequestBody Article article){
        articleService.addArticle(article);
        return Result.ok();
    }

    //根据id查询
    @Operation(summary = "根据id查询")
    @GetMapping("getArticle/{id}")
    public Result getArticle(@PathVariable Integer id){
        Article article =  articleService.getArticle(id);
        return Result.ok(article);
    }

    //修改article
    @Operation(summary = "修改article")
    @PutMapping("updateArticle")
    public Result updateArticle(@RequestBody Article article){
        articleService.updateArticle(article);
        return Result.ok();
    }

    @Operation(summary = "根据id删除article")
    @DeleteMapping("deleteArticle/{id}")
    public Result deleteArticle(@PathVariable Integer id){
        articleService.deleteArticle(id);
        return Result.ok();
    }

}
