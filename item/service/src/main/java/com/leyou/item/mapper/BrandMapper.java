package com.leyou.item.mapper;

import com.leyou.item.domain.Brand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BrandMapper {

    List<Brand>selectLikeByName(@Param("name") String name);
    List<Brand>selectAll();
    Brand selectByid(@Param("id") Long id);

    int insertBrandAndCategory(@Param("cid") Long cid,@Param("bid") Long bid);

    int insertBrandById(Brand brand);

}
