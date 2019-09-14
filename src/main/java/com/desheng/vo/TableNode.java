package com.desheng.vo;

/**
 * 用户列表 查看分配角色用
 */

public class TableNode {

    private Integer id;

    private String name;

    private String description;

    private Integer status;

    private boolean checked;// 是否选中

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    @Override
    public String toString() {
        return "TableNode [id=" + id + ", name=" + name + ", description=" + description + ", status=" + status
                + ", checked=" + checked + "]";
    }

}
