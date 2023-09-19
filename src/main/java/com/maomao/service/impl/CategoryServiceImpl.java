package com.maomao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maomao.mapper.CategoryMapper;
import com.maomao.pojo.Category;
import com.maomao.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> queryList() {
        return categoryMapper.queryList();
    }

    @Override
    public void addCategory(Category category) {
        categoryMapper.addCategory(category);
    }

    @Override
    public Category getCategory(Integer cid) {
        return categoryMapper.getCategory(cid);
    }

    @Override
    public void updateCategory(Category category) {
        categoryMapper.updateCategory(category);
    }

    @Override
    public void deleteCategory(Integer cid) {
        categoryMapper.deleteCategory(cid);
    }

    @Override
    public Map<String,Object> queryListPage(Integer current, Integer limit, Category category) {
        PageHelper.startPage(current,limit);
        List<Category> categoryList = categoryMapper.queryListByCondition(category);
        PageInfo<Category> pageInfo = new PageInfo<>(categoryList);
        long total = pageInfo.getTotal();
        List<Category> list = pageInfo.getList();
        Map<String,Object> map = new HashMap<>();
        map.put("total",total);
        map.put("list",list);
        return map;
    }

    @Override
    public Integer getCategoryCount() {
        return categoryMapper.getCategoryCount();
    }
}
