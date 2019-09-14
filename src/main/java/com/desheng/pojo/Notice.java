package com.desheng.pojo;

import java.util.Date;

public class Notice {
    private Integer id;

    private Integer wzItfId;

    private String point;

    private String title;

    private String content;

    private Date pushTime;

    private String read;

    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWzItfId() {
        return wzItfId;
    }

    public void setWzItfId(Integer wzItfId) {
        this.wzItfId = wzItfId;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point == null ? null : point.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getPushTime() {
        return pushTime;
    }

    public void setPushTime(Date pushTime) {
        this.pushTime = pushTime;
    }

    public String getRead() {
        return read;
    }

    public void setRead(String read) {
        this.read = read == null ? null : read.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}