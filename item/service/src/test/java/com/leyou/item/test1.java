package com.leyou.item;

import org.junit.jupiter.api.Test;

public class test1 {

    @Test
    public void mytest()
    {
        String s = "aa";
        String ss = s.substring(2);
        System.out.println(ss);
        System.out.println(ss==null);
        System.out.println(ss.length());
    }

}
