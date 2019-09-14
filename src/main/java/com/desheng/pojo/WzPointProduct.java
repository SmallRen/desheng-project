package com.desheng.pojo;

public class WzPointProduct {
    private Integer wzPointId;

    private Integer wzProductScode;

    private Integer isDefault;

    private String sign;

    public Integer getWzPointId() {
        return wzPointId;
    }

    public void setWzPointId(Integer wzPointId) {
        this.wzPointId = wzPointId;
    }

    public Integer getWzProductScode() {
        return wzProductScode;
    }

    public void setWzProductScode(Integer wzProductScode) {
        this.wzProductScode = wzProductScode;
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
        this.sign = sign == null ? null : sign.trim();
    }
}