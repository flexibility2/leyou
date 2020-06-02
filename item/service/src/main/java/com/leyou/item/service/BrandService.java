package com.leyou.item.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leyou.common.domain.PageResult;
import com.leyou.item.domain.Brand;
import com.leyou.item.mapper.BrandMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BrandService {

    @Autowired
    BrandMapper brandMapper;

    public PageResult<Brand> queryBrandsByPage(String key, Integer page, Integer rows, String sortBy, Boolean desc) {

//        // 初始化example对象
//        Example example = new Example(Brand.class);
//        Example.Criteria criteria = example.createCriteria();
//
//        // 根据name模糊查询，或者根据首字母查询
//        if (StringUtils.isNotBlank(key)) {
//            criteria.andLike("name", "%" + key + "%").orEqualTo("letter", key);
//        }


//        // 添加排序条件
//        if (StringUtils.isNotBlank(sortBy)) {
//            example.setOrderByClause(sortBy + " " + (desc ? "desc" : "asc"));
//        }

        if (StringUtils.isNotBlank(sortBy))
        {
            String sortBystr = sortBy + " " + (desc?"desc":"asc");

            // 添加分页条件
            PageHelper.startPage(page, rows,sortBystr);
        }
        else
        {
            // 添加分页条件
            PageHelper.startPage(page, rows);
        }


        //List<Brand> brands = this.brandMapper.selectByExample(example);
        List<Brand> brands;
        if (StringUtils.isNotBlank(key))
        {
            String likeName = "%" + key + "%";
            brands= brandMapper.selectLikeByName(likeName);
        }
        else {
            brands = brandMapper.selectAll();
        }

        // 包装成pageInfo
        PageInfo<Brand> pageInfo = new PageInfo<>(brands);
        // 包装成分页结果集返回
        return new PageResult<>(pageInfo.getTotal(), pageInfo.getList());
    }

    @Transactional
    public void saveBrand(Brand brand,List<Long>cids)
    {
        final Long bid = brand.getId();
        System.out.println(String.format("bid: %d",bid));
        this.brandMapper.insertBrandById(brand);

        cids.forEach(cid->{
            System.out.println(String.format("cid: %d, bid: %d",cid,brand.getId()));
            this.brandMapper.insertBrandAndCategory(cid,brand.getId());
        });
    }

}

