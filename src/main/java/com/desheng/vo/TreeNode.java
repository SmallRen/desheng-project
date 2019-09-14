package com.desheng.vo;

import java.util.List;

public class TreeNode {

    private String title;//	节点标题

    private int id;//节点唯一索引，用于对指定节点进行各类操作

    private List<TreeNode> children;//	子节点。支持设定选项同父节点

    private String href;//	点击节点弹出新窗口对应的 url。需开启 isJump 参数	String	任意 URL

    private boolean spread;    //节点是否初始展开，默认 false	Boolean	true

    private boolean checked;//	节点是否初始为选中状态（如果开启复选框的话），默认 false	Boolean	true

    private boolean disabled;//	节点是否为禁用状态。默认 false	Boolean	false

    @Override
    public String toString() {
        return "TreeNode{" +
                "title='" + title + '\'' +
                ", id=" + id +
                ", children=" + children +
                ", href='" + href + '\'' +
                ", spread=" + spread +
                ", checked=" + checked +
                ", disabled=" + disabled +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public boolean isSpread() {
        return spread;
    }

    public void setSpread(boolean spread) {
        this.spread = spread;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }
}
