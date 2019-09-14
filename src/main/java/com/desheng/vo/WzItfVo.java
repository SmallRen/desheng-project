package com.desheng.vo;

import com.desheng.pojo.WzItf;
import com.desheng.pojo.WzItfDetailed;
import com.desheng.pojo.WzWorkLine;

import java.util.List;

/**
 * 工单聚合vo  包含路线 ，物资
 * 这个三个pojo类 合在一起
 */
public class WzItfVo extends WzItf {
    //物资
    private List<WzItfDetailed> wzItfDetailedList;
    //路线
    private List<WzWorkLine> wzWorkLineList;

    //物资
    private String wzItfDetailed;
    //路线
    private String wzWorkLine;

    public List<WzItfDetailed> getWzItfDetailedList() {
        return wzItfDetailedList;
    }

    public void setWzItfDetailedList(List<WzItfDetailed> wzItfDetailedList) {
        this.wzItfDetailedList = wzItfDetailedList;
    }

    public List<WzWorkLine> getWzWorkLineList() {
        return wzWorkLineList;
    }

    public void setWzWorkLineList(List<WzWorkLine> wzWorkLineList) {
        this.wzWorkLineList = wzWorkLineList;
    }

    public String getWzItfDetailed() {
        return wzItfDetailed;
    }

    public void setWzItfDetailed(String wzItfDetailed) {
        this.wzItfDetailed = wzItfDetailed;
    }

    public String getWzWorkLine() {
        return wzWorkLine;
    }

    public void setWzWorkLine(String wzWorkLine) {
        this.wzWorkLine = wzWorkLine;
    }

    @Override
    public String toString() {
        return "WzItfVo{" +
                "wzItfDetailedList=" + wzItfDetailedList +
                ", wzWorkLineList=" + wzWorkLineList +
                ", wzItfDetailed='" + wzItfDetailed + '\'' +
                ", wzWorkLine='" + wzWorkLine + '\'' +
                '}';
    }
}
