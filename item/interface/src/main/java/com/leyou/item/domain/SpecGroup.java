package com.leyou.item.domain;

public class SpecGroup {

    private Long id;
    private Long cid;
    private String name;

    @Override
    public String toString() {
        return "SpecGroup{" +
                "id=" + id +
                ", cid=" + cid +
                ", name='" + name + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
