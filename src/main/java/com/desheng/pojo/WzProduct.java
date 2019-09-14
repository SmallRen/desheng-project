package com.desheng.pojo;

import java.util.Date;

public class WzProduct {
    private Integer id;

    private String wzScode;

    private String wzName;

    private String wzSspce;

    private Date createTime;

    private String createPerson;

    private Date updateTime;

    private String updatePerson;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWzScode() {
        return wzScode;
    }

    public void setWzScode(String wzScode) {
        this.wzScode = wzScode;
    }

    public String getWzName() {
        return wzName;
    }

    public void setWzName(String wzName) {
        this.wzName = wzName == null ? null : wzName.trim();
    }

    public String getWzSspce() {
        return wzSspce;
    }

    public void setWzSspce(String wzSspce) {
        this.wzSspce = wzSspce == null ? null : wzSspce.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson == null ? null : createPerson.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdatePerson() {
        return updatePerson;
    }

    public void setUpdatePerson(String updatePerson) {
        this.updatePerson = updatePerson == null ? null : updatePerson.trim();
    }
}