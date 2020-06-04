package com.leyou.item.mapper;


import com.leyou.item.domain.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CategoryMapper {

    List<Category>selectByPid(@Param("parentId") long pid);

    List<Category>selectById(List<Long>ids);

}
