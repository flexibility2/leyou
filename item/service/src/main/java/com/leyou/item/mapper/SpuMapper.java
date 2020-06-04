package com.leyou.item.mapper;

import com.leyou.item.domain.Spu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SpuMapper {

    List<Spu>selectByTitle(@Param("key")String key,@Param("saleable") Boolean saleable);

}
