package com.leyou.item.mapper;

import com.leyou.item.domain.SpecParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SpecParamMapper {

    List<SpecParam>selectALlByGid(@Param("gid") Long gid);

    List<SpecParam> selectALlByAll(Long gid, Long cid, Boolean generic, Boolean searching);

//    List<SpecParam>selectALlByAll()

}
