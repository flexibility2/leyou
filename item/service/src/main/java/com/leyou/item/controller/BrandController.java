package com.leyou.item.controller;

import com.leyou.common.domain.PageResult;
import com.leyou.item.domain.Brand;
import com.leyou.item.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping("page")
    public ResponseEntity<PageResult<Brand>> queryBrandsByPage(
            @RequestParam(value = "key", required = false)String key,
            @RequestParam(value = "page", defaultValue = "1")Integer page,
            @RequestParam(value = "rows", defaultValue = "5")Integer rows,
            @RequestParam(value = "sortBy", required = false)String sortBy,
            @RequestParam(value = "desc", required = false)Boolean desc
    ){
        PageResult<Brand> result = this.brandService.queryBrandsByPage(key, page, rows, sortBy, desc);
        if (CollectionUtils.isEmpty(result.getItems())){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<Void>saveBrand(Brand brand, @RequestParam("cids")List<Long>cids)
    {
        this.brandService.saveBrand(brand,cids);
        return ResponseEntity.status(HttpStatus.CREATED).build();
//        return ResponseEntity.notFound().build();
    }


    @GetMapping("cid/{cid}")
    public ResponseEntity<List<Brand>>queryBrandByCid(@PathVariable("cid")Long cid)
    {

        List<Brand>brands  = brandService.queryBrandsByCid(cid);
        if (CollectionUtils.isEmpty(brands))
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(brands);

    }
}


