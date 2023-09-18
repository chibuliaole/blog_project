package com.maomao.mapper;

import com.maomao.pojo.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {
    List<Article> getAll();

    List<Article> queryList(Article article);

    void addArticle(Article article);

    Article getArticle(Integer id);

    void updateArticle(Article article);

    void deleteArticle(Integer id);
}
