package com.maomao.service;

import com.maomao.pojo.Category;

import java.util.List;
import java.util.Map;

public interface CategoryService {
    List<Category> queryList();

    void addCategory(Category category);

    Category getCategory(Integer cid);

    void updateCategory(Category category);

    void deleteCategory(Integer cid);

    Map<String,Object> queryListPage(Integer current, Integer limit, Category category);

    Integer getCategoryCount();
}
