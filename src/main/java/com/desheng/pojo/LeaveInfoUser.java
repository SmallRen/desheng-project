package com.desheng.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class LeaveInfoUser extends LeaveInfoUserKey {
    private String username;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date spTime;

    private String spUserStatus;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Date getSpTime() {
        return spTime;
    }

    public void setSpTime(Date spTime) {
        this.spTime = spTime;
    }

    public String getSpUserStatus() {
        return spUserStatus;
    }

    public void setSpUserStatus(String spUserStatus) {
        this.spUserStatus = spUserStatus == null ? null : spUserStatus.trim();
    }
}