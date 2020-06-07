package com.wxt;

import com.wxt.domain.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

@SpringBootTest(classes = Application.class)
public class indexTest {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Test
    public void test1()
    {
        // 创建索引，会根据Item类的@Document注解信息来创建
        elasticsearchTemplate.createIndex(Item.class);
//        elasticsearchRestTemplate.createIndex(Item.class);
                // 配置映射，会根据Item类中的id、Field等字段来自动完成映射
//        elasticsearchTemplate.putMapping(Item.class);
//        elasticsearchRestTemplate.putMapping(Item.class);
    }

}
