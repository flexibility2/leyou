package com.leyou.item;

import com.leyou.common.domain.PageResult;
import com.leyou.item.domain.Brand;
import com.leyou.item.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class testBrandService {

    @Autowired
    BrandService brandService;

    @Test
    public void test1()
    {
        PageResult<Brand>result = brandService.queryBrandsByPage(null,1,5,null,null);
        System.out.println(result);
//        String
    }

    @Test
    public void mytest()
    {
        String s = "aa";
        String ss = s.substring(2);
        System.out.println(ss);
    }

}
