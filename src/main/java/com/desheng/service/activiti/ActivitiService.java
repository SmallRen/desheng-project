package com.desheng.service.activiti;

public interface ActivitiService {


    /**
     * 部署流程定义
     *
     * @param modelId
     * @return
     */
    Object activitiDeploy(String modelId) throws Exception;

}
