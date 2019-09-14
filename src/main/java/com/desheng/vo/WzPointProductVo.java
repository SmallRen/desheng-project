package com.desheng.vo;

import com.desheng.pojo.WzPointProduct;

/**
 * 物资对应点位 查询 vo
 */
public class WzPointProductVo {
    private String pName;
    private int isDefaulp;
    private String wzName;
    private String wzSspce;
    private Integer isDefault;

    private String sign;
    private int id; //点位主键

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getIsDefaulp() {
        return isDefaulp;
    }

    public void setIsDefaulp(int isDefaulp) {
        this.isDefaulp = isDefaulp;
    }

    public String getWzName() {
        return wzName;
    }

    public void setWzName(String wzName) {
        this.wzName = wzName;
    }

    public String getWzSspce() {
        return wzSspce;
    }

    public void setWzSspce(String wzSspce) {
        this.wzSspce = wzSspce;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
