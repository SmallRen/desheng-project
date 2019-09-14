package com.desheng.controller;

import com.desheng.service.activiti.ActivitiService;
import com.desheng.util.ResultInfo;
import com.desheng.util.ResultMsg;
import com.desheng.vo.ActReProcdefVo;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.editor.constants.ModelDataJsonConstants;
import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.repository.Model;
import org.activiti.engine.repository.ProcessDefinition;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

//请创建service 修改代码结构
@Controller
public class ActivitiController {
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private ActivitiService activitiService;

    private static Logger log = LoggerFactory.getLogger(ActivitiController.class);

    /**
     * 新建一个空模型
     */
    @RequestMapping("activiti/create")
    @ResponseBody
    public Object newModel(String name, String description, String key, HttpServletResponse response) throws IOException {
        // 初始化一个空模型
        Model model = repositoryService.newModel();
        // 设置一些默认信息
        // String name = "new-process";
        // String description = "";
        int revision = 1;
        //String key = "process";
        ObjectNode modelNode = objectMapper.createObjectNode();
        modelNode.put(ModelDataJsonConstants.MODEL_NAME, name);
        modelNode.put(ModelDataJsonConstants.MODEL_DESCRIPTION, description);
        modelNode.put(ModelDataJsonConstants.MODEL_REVISION, revision);
        model.setName(name);
        model.setKey(key);
        model.setMetaInfo(modelNode.toString());
        repositoryService.saveModel(model);
        String id = model.getId();
        // 完善ModelEditorSource
        ObjectNode editorNode = objectMapper.createObjectNode();
        editorNode.put("id", "canvas");
        editorNode.put("resourceId", "canvas");
        ObjectNode stencilSetNode = objectMapper.createObjectNode();
        stencilSetNode.put("namespace", "http://b3mn.org/stencilset/bpmn2.0#");
        editorNode.put("stencilset", stencilSetNode);
        repositoryService.addModelEditorSource(id, editorNode.toString().getBytes("utf-8"));
        //response.sendRedirect("/modeler.html?modelId=" + id);
        return ResultMsg.successData("/modeler.html?modelId=" + id, "新增模型成功");
    }

    @RequestMapping("modelist")
    public String modelList(org.springframework.ui.Model model) {
        List<Model> models = repositoryService.createModelQuery().orderByCreateTime().desc().list();
        model.addAttribute("models", models);
        return "list";
    }

    /**
     * 查询工作流模型
     *
     * @return
     */
    @RequestMapping("activiti/modelist")
    @ResponseBody
    public ResultInfo modelList() {
        List<Model> models = repositoryService.createModelQuery().orderByCreateTime().desc().list();
        ResultInfo resultPageInfo = ResultInfo.dataInfo(0,   models.size(), models);
        return resultPageInfo;
    }

    /**
     * 查询部署工作流模型信息
     * 表: act_re_procdef
     *
     * @return
     */
    @RequestMapping("activiti/deployModelList")
    @ResponseBody
    public ResultInfo deployModelList() {
        String sql = "SELECT a.`ID_`,a.`CATEGORY_`,a.`KEY_`,a.`DEPLOYMENT_ID_`,a.`RESOURCE_NAME_`,a.`DGRM_RESOURCE_NAME_`,b.`NAME_` FROM act_re_procdef a LEFT JOIN act_re_model b ON a.`DEPLOYMENT_ID_` = b.`DEPLOYMENT_ID_` WHERE b.`DEPLOYMENT_ID_` IS NOT NULL ";
        List<ProcessDefinition> list = repositoryService.createNativeProcessDefinitionQuery().sql(sql).list();
        List<ActReProcdefVo> list1 = new ArrayList<>();
        for (ProcessDefinition processDefinition : list) {
            ActReProcdefVo actReProcdefVo = new ActReProcdefVo();
            try {
                BeanUtils.copyProperties(actReProcdefVo, processDefinition);
                list1.add(actReProcdefVo);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        ResultInfo resultPageInfo = ResultInfo.dataInfo(0,   list1.size(), list1);
        return resultPageInfo;
    }

    /**
     * 发布模型为流程部署
     */
    @RequestMapping("activiti/deploy/{id}")
    @ResponseBody
    public Object activitiDeploy(@PathVariable("id") String modelId) throws Exception {
        if (StringUtils.isBlank(modelId)) {
            return ResultMsg.failure("流程部署ID为空");
        }
        Object deploy = activitiService.activitiDeploy(modelId);
        return deploy;
    }

    /**
     * 流程部署用
     * 级联删除 已经在使用的流程实例信息也会被级联删除
     *
     * @param deploymentId 流程部署ID
     */
    @RequestMapping("activiti/delete/{id}")
    @ResponseBody
    public Object deleteCascade(@PathVariable("id") String deploymentId) {
        //repositoryService.deleteModel(deploymentId); //删除新建流程还没有部署
        // 默认是false true就是级联删除 deploymentId 流程部署ID,不会删除流程但是会清除该部署后的所有信息
        //  System.out.println(deploymentId);
        if (StringUtils.isBlank(deploymentId) || "null".equalsIgnoreCase(deploymentId)) {
            return ResultMsg.success("流程未部署不能删除");
        }
        repositoryService.deleteDeployment(deploymentId, true);
        //System.out.println("刪除流程定义");
        return ResultMsg.success("刪除流程定义成功");
    }
/**
 * 导出
 * 1 获取节点信息
 * 2 转换为xml数据
 * 3 写入流中输出
 */
    /**
     * 导出model的xml文件
     */
    @RequestMapping(value = "activiti/export")
    public void export(@RequestParam("modelId") String modelId, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try {
            Model modelData = repositoryService.getModel(modelId);
            BpmnJsonConverter jsonConverter = new BpmnJsonConverter();
            //获取节点信息
            byte[] arg0 = repositoryService.getModelEditorSource(modelData.getId());
            JsonNode editorNode = new ObjectMapper().readTree(arg0);
            //将节点信息转换为xml
            BpmnModel bpmnModel = jsonConverter.convertToBpmnModel(editorNode);
            BpmnXMLConverter xmlConverter = new BpmnXMLConverter();
            byte[] bpmnBytes = xmlConverter.convertToXML(bpmnModel);

            ByteArrayInputStream in = new ByteArrayInputStream(bpmnBytes);
//                String filename = bpmnModel.getMainProcess().getId() + ".bpmn20.xml";
            String filename = modelData.getName() + ".bpmn20.xml";
            response.setContentType("application/x-msdownload;");
            response.setHeader("Content-Disposition", "attachment; filename=" + java.net.URLEncoder.encode(filename, "UTF-8"));
            IOUtils.copy(in, response.getOutputStream());
            response.flushBuffer();
        } catch (Exception e) {
            PrintWriter out = null;
            try {
                out = response.getWriter();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            out.write("未找到对应数据");
            out.close();
            e.printStackTrace();
        }
    }

    //查询历史节点信息
    @RequestMapping("activiti/queryHistoric")
    public void queryHistoricInstance() {
        List<HistoricProcessInstance> list = historyService.createHistoricProcessInstanceQuery().orderByProcessInstanceStartTime().desc().list();
        for (HistoricProcessInstance historicProcessInstance : list) {
            log.info("历史节点" + historicProcessInstance);
        }
    }


}
