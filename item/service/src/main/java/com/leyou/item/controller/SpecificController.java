package com.leyou.item.controller;

import com.leyou.item.domain.SpecGroup;
import com.leyou.item.domain.SpecParam;
import com.leyou.item.service.SpecificService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("spec")
public class SpecificController {

    @Autowired
    SpecificService specificService;

    @GetMapping("groups/{cid}")
    public ResponseEntity<List<SpecGroup>>querySpecGroupByCid(@PathVariable("cid")Long cid)
    {
        List<SpecGroup>specGroups = specificService.querySpecGroupByCid(cid);
        if (CollectionUtils.isEmpty(specGroups))
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(specGroups);
    }


    @GetMapping("params")
    public ResponseEntity<List<SpecParam>>querySpecParamByGid(@RequestParam("gid")Long gid)
    {
        List<SpecParam>specParams = specificService.querySpecParamByGid(gid);
        if (CollectionUtils.isEmpty(specParams))
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(specParams);
    }

}
