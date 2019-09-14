package com.desheng.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class Permission {
    private Integer id;

    private String name;

    private String description;

    private String url;

    private String perms;

    private Integer parentId;

    private Integer type;

    private Integer orderNum;

    private String icon;

    private Integer status;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;
	


}