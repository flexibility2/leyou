package com.leyou.item.service;

import com.leyou.item.domain.SpecGroup;
import com.leyou.item.domain.SpecParam;
import com.leyou.item.mapper.SpecGroupMapper;
import com.leyou.item.mapper.SpecParamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class SpecificService {

    @Autowired
    SpecGroupMapper specGroupMapper;

    @Autowired
    SpecParamMapper specParamMapper;

    public List<SpecGroup>querySpecGroupByCid(Long cid)
    {
        return specGroupMapper.selectAll(cid);
    }

    public List<SpecParam>querySpecParamByGid(Long gid)
    {
        return specParamMapper.selectALlByGid(gid);
    }

    public List<SpecParam>querySpecParamByGid(Long gid,Long cid,Boolean generic,Boolean searching)
    {
        return specParamMapper.selectALlByAll(gid,cid,generic,searching);
    }

}
