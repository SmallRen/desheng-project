package com.desheng.util;

import java.io.Serializable;
import java.util.List;

/**
 * 返回结果工具类
 * 里面包括 layui 分页需要的字段
 */
public class ResultInfo<T> implements Serializable {
    int page;//起始页
    int limit;//页数大小
    /**
     * 返回数量
     */
    private long count;
    /**
     * 0成功 ，其余失败
     */
    private int code;
    /**
     * 返回消息
     */
    private String msg;

    /**
     * 返回数据
     */
    private List<?> data;
    private T example;//任何类型条件

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public T getExample() {
        return example;
    }

    public void setExample(T example) {
        this.example = example;
    }

    @Override
    public String toString() {
        return "ResultInfo{" +
                "page=" + page +
                ", limit=" + limit +
                ", count=" + count +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", example=" + example +
                '}';
    }

    /**
     * 前台表格成功信息
     *
     * @param size
     * @param data
     * @return
     */
    public static ResultInfo dataInfo(int code, long size, List<?> data) {
        ResultInfo resultPageInfo = new ResultInfo();
        resultPageInfo.setCode(code);
        if (code == 0) {
            resultPageInfo.setMsg("执行成功");
        } else {
            resultPageInfo.setMsg("执行失败");
        }
        resultPageInfo.setData(data);
        resultPageInfo.setCount(size);
        return resultPageInfo;
    }
}
