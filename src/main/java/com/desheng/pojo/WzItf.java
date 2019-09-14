package com.desheng.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class WzItf {
    private Integer id;

    private String createUnit;

    private String createPerson;

    private Integer ywType;

    private String ewmType;

    private Integer ewmNumber;

    private String fhUnit;

    private String shUnit;

    private String cph;

    private String bjTime;//不要

    private String ccDoor;//不要

    private String jcDoor;//不要

    private String worklineSys;//不要

    private String worklinePerson;//不要
    private WzItfDetailed detailed;
    private WzWorkLine line;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTiem;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    private String updatePerson;

    private Integer gdStatus;

    private String gdMark;

    private Integer spStatus;

    public Integer getSpStatus() {
        return spStatus;
    }

    public void setSpStatus(Integer spStatus) {
        this.spStatus = spStatus;
    }

    private String[] wzName; //物资名称

    private String[] wzNumber; //物资数量

    private String[] wzSspce; //物资规格

    private String[] point;//物资线路

    public String[] getWzName() {
        return wzName;
    }

    public void setWzName(String[] wzName) {
        this.wzName = wzName;
    }

    public String[] getWzNumber() {
        return wzNumber;
    }

    public void setWzNumber(String[] wzNumber) {
        this.wzNumber = wzNumber;
    }

    public String[] getWzSspce() {
        return wzSspce;
    }

    public void setWzSspce(String[] wzSspce) {
        this.wzSspce = wzSspce;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreateUnit() {
        return createUnit;
    }

    public void setCreateUnit(String createUnit) {
        this.createUnit = createUnit == null ? null : createUnit.trim();
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson == null ? null : createPerson.trim();
    }

    public Integer getYwType() {
        return ywType;
    }

    public void setYwType(Integer ywType) {
        this.ywType = ywType;
    }

    public String getEwmType() {
        return ewmType;
    }

    public void setEwmType(String ewmType) {
        this.ewmType = ewmType == null ? null : ewmType.trim();
    }

    public Integer getEwmNumber() {
        return ewmNumber;
    }

    public void setEwmNumber(Integer ewmNumber) {
        this.ewmNumber = ewmNumber;
    }

    public String getFhUnit() {
        return fhUnit;
    }

    public void setFhUnit(String fhUnit) {
        this.fhUnit = fhUnit == null ? null : fhUnit.trim();
    }

    public String getShUnit() {
        return shUnit;
    }

    public void setShUnit(String shUnit) {
        this.shUnit = shUnit == null ? null : shUnit.trim();
    }

    public String getCph() {
        return cph;
    }

    public void setCph(String cph) {
        this.cph = cph == null ? null : cph.trim();
    }

    public String getBjTime() {
        return bjTime;
    }

    public void setBjTime(String bjTime) {
        this.bjTime = bjTime == null ? null : bjTime.trim();
    }

    public String getCcDoor() {
        return ccDoor;
    }

    public void setCcDoor(String ccDoor) {
        this.ccDoor = ccDoor == null ? null : ccDoor.trim();
    }

    public String getJcDoor() {
        return jcDoor;
    }

    public void setJcDoor(String jcDoor) {
        this.jcDoor = jcDoor == null ? null : jcDoor.trim();
    }

    public String getWorklineSys() {
        return worklineSys;
    }

    public void setWorklineSys(String worklineSys) {
        this.worklineSys = worklineSys == null ? null : worklineSys.trim();
    }

    public String getWorklinePerson() {
        return worklinePerson;
    }

    public void setWorklinePerson(String worklinePerson) {
        this.worklinePerson = worklinePerson == null ? null : worklinePerson.trim();
    }

    public Date getCreateTiem() {
        return createTiem;
    }

    public void setCreateTiem(Date createTiem) {
        this.createTiem = createTiem;
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

    public Integer getGdStatus() {
        return gdStatus;
    }

    public void setGdStatus(Integer gdStatus) {
        this.gdStatus = gdStatus;
    }

    public String getGdMark() {
        return gdMark;
    }

    public void setGdMark(String gdMark) {
        this.gdMark = gdMark == null ? null : gdMark.trim();
    }

    public String[] getPoint() {
        return point;
    }

    public void setPoint(String[] point) {
        this.point = point;
    }

    public WzItfDetailed getDetailed() {
        return detailed;
    }

    public void setDetailed(WzItfDetailed detailed) {
        this.detailed = detailed;
    }

    public WzWorkLine getLine() {
        return line;
    }

    public void setLine(WzWorkLine line) {
        this.line = line;
    }
}