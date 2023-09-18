package com.maomao.service;

import com.maomao.pojo.Article;

import java.util.List;

public interface ArticleService {
    List<Article> getAll();

    List<Article> queryList(Article article);

    void addArticle(Article article);

    Article getArticle(Integer id);

    void updateArticle(Article article);

    void deleteArticle(Integer id);
}
