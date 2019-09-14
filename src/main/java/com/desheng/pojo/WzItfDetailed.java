package com.desheng.pojo;

public class WzItfDetailed extends WzItfDetailedKey {
    private String wzName;

    private String wzNumber;

    private String wzSspce;

    private String wzScode;

    public String getWzName() {
        return wzName;
    }

    public void setWzName(String wzName) {
        this.wzName = wzName == null ? null : wzName.trim();
    }

    public String getWzNumber() {
        return wzNumber;
    }

    public void setWzNumber(String wzNumber) {
        this.wzNumber = wzNumber == null ? null : wzNumber.trim();
    }

    public String getWzSspce() {
        return wzSspce;
    }

    public void setWzSspce(String wzSspce) {
        this.wzSspce = wzSspce == null ? null : wzSspce.trim();
    }

    public String getWzScode() {
        return wzScode;
    }

    public void setWzScode(String wzScode) {
        this.wzScode = wzScode == null ? null : wzScode.trim();
    }

    @Override
    public String toString() {
        return "WzItfDetailed{" +
                "wzName='" + wzName + '\'' +
                ", wzNumber='" + wzNumber + '\'' +
                ", wzSspce='" + wzSspce + '\'' +
                ", wzScode='" + wzScode + '\'' +
                '}';
    }
}