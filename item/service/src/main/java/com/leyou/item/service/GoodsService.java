package com.leyou.item.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leyou.common.domain.PageResult;
import com.leyou.item.bo.SpuBo;
import com.leyou.item.domain.Spu;
import com.leyou.item.domain.SpuDetail;
import com.leyou.item.mapper.BrandMapper;
import com.leyou.item.mapper.SpuDetailMapper;
import com.leyou.item.mapper.SpuMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class GoodsService {

    @Autowired
    private SpuMapper spuMapper;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BrandMapper brandMapper;

    @Autowired
    private SpuDetailMapper spuDetailMapper;


    public PageResult<SpuBo>querySpuBoByPage(String key, Boolean saleable, Integer page, Integer rows)
    {
        String likeTitle = "%" + key + "%";

        PageHelper.startPage(page,rows);
        List<Spu>spus = spuMapper.selectByTitle(likeTitle,saleable);
        PageInfo<Spu>pageInfo = new PageInfo<>(spus);

        List<SpuBo>spuBos = new ArrayList<>();
        spus.forEach(
                spu -> {
                    SpuBo spuBo = new SpuBo();
                    BeanUtils.copyProperties(spu,spuBo);
                    List<String>names = this.categoryService.queryNameByIds(Arrays.asList(spu.getCid1(),spu.getCid2(),spu.getCid3()));
                    spuBo.setCname(StringUtils.join(names,"/"));

                    spuBo.setBname(this.brandMapper.selectByid(spu.getBrandId()).getName());
                    spuBos.add(spuBo);
                }
        );
        return new PageResult<>(pageInfo.getTotal(),spuBos);

    }

    @Transactional
    public void saveGoods(SpuBo spuBo)
    {
        spuBo.setSaleable(true);
        spuBo.setValid(true);
        spuBo.setCreateTime(new Date());
        spuBo.setLastUpdateTime(spuBo.getCreateTime());
        int cnt = this.spuMapper.insertSelective(spuBo);

        SpuDetail spuDetail = spuBo.getSpuDetail();

        spuDetail.setSpuId(spuBo.getId());
        this.spuDetailMapper.insertSpuDetails(spuDetail);

//        saveSkuAndStock();

    }

    private void saveSkuAndStock()
    {

    }

}
