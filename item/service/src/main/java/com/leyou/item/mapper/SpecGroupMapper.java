package com.leyou.item.mapper;
import com.leyou.item.domain.SpecGroup;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface SpecGroupMapper {

    List<SpecGroup>selectAll(@Param("cid") Long cid);

}
