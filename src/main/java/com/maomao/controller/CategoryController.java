package com.maomao.controller;

import com.maomao.pojo.Category;
import com.maomao.service.CategoryService;
import com.maomao.util.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.OnClose;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@CrossOrigin
@RequestMapping("/category")
@Tag(name = "分类管理")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("queryList")
    @Operation(summary = "查询列表")
    public Result queryList(){
        List<Category> categoryList = categoryService.queryList();
        return Result.ok(categoryList);
    }

    @PostMapping("addCategory")
    @Operation(summary = "增加分类")
    public Result addCategory(@RequestBody Category category){
        categoryService.addCategory(category);
        return Result.ok();
    }

    @GetMapping("getCategory/{cid}")
    @Operation(summary = "根据id查询")
    public Result getCategory(@PathVariable Integer cid){
        Category category = categoryService.getCategory(cid);
        return Result.ok(category);
    }

    @PutMapping("updateCategory")
    @Operation(summary = "更新分类")
    public Result updateCategory(@RequestBody Category category){
        categoryService.updateCategory(category);
        return Result.ok();
    }

    @DeleteMapping("deleteCategory/{cid}")
    @Operation(summary = "根据id删除分类")
    public Result deleteCategory(@PathVariable Integer cid){
        categoryService.deleteCategory(cid);
        return Result.ok();
    }

    @PostMapping("queryListPage/{current}/{limit}")
    @Operation(summary = "分页查询分类")
    public Result pageCategory(@PathVariable Integer current,@PathVariable Integer limit, @RequestBody(required = false) Category category){
        Map<String, Object> categoryMap =  categoryService.queryListPage(current,limit,category);
        return Result.ok(categoryMap);
    }

    @Operation(summary = "获取分类总数")
    @GetMapping("/getCategoryCount")
    public Result getCategoryCount(){
        Integer count = categoryService.getCategoryCount();
        return Result.ok(count);
    }

}
