package com.leyou.item.service;

import com.leyou.item.domain.Category;
import com.leyou.item.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category>queryCategoriesByPid(long pid)
    {
        return categoryMapper.selectByPid(pid);
    }

    public List<String>queryNameByIds(List<Long>ids)
    {
        List<Category>list = this.categoryMapper.selectById(ids);

        List<String>names = new ArrayList<>();

        for (Category category: list)
        {
            names.add(category.getName());
        }
        return names;
    }

}
