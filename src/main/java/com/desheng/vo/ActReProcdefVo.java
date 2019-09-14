package com.desheng.vo;

import lombok.Data;

/**
 * 部署流程模型信息vo
 */
@Data
public class ActReProcdefVo {

    private String id;

    private Integer rev;

    private String category;

    private String name;

    private String key;

    private Integer version;

    private String deploymentId;

    private String resourceName;

    private String dgrmResourceName;


}
