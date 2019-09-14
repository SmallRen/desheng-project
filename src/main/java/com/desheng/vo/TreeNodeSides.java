package com.desheng.vo;

import java.util.List;

/**
 * 第三方树  权限里面用
 */
public class TreeNodeSides {
    private Integer value;// 显示的值

    private String title;// 隐藏的值

    private boolean checked; // 是否选中;

    private Integer type; // 前台树图标区分是按钮还是菜单 不展示

    private List<TreeNodeSides> data; // 子节点数据


    @Override
    public String toString() {
        return "TreeNode [value=" + value + ", title=" + title + ",type=" + type + ", checked=" + checked + ", data=" + data + "]";
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<TreeNodeSides> getData() {
        return data;
    }

    public void setData(List<TreeNodeSides> data) {
        this.data = data;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

}
