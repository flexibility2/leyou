package com.leyou.item.bo;

import com.leyou.item.domain.Spu;

public class SpuBo extends Spu {

    String cname;

    String bname;


    @Override
    public String toString() {
        return "SpuBo{" +
                "cname='" + cname + '\'' +
                ", bname='" + bname + '\'' +
                '}';
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }
}
