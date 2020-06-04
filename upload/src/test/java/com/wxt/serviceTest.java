package com.wxt;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
public class serviceTest {


    @Autowired
    RestTemplate restTemplate;

    @Test
    public void test()
    {

    }

}
