package com.maomao.mapper;

import com.maomao.pojo.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
    List<Category> queryList();

    void addCategory(Category category);

    Category getCategory(Integer cid);

    void updateCategory(Category category);

    void deleteCategory(Integer cid);

    List<Category> queryListByCondition(Category category);
}
