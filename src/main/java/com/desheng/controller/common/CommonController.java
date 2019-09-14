package com.desheng.controller.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

import com.desheng.config.ServerConfig;
import com.desheng.pojo.FileUplod;
import com.desheng.service.file.FileUplodService;
import com.desheng.service.file.FileUplodTypeService;
import com.desheng.util.ResultInfo;
import com.desheng.util.ResultMsg;
import com.desheng.util.file.FileUploadUtils;
import com.desheng.vo.TreeNode;

import java.io.IOException;
import java.util.List;

/**
 * 文件上传
 * 通用请求处理
 *
 * @author ruoyi
 */
@Controller
public class CommonController {

    @Value("${file.uploadPath}")
    private String uploadPath; //文件路径
    @Autowired
    private ServerConfig serverConfig;
    @Autowired
    private FileUplodService fileUplodService;
    @Autowired
    private FileUplodTypeService fileUplodTypeService;

    /**
     * 通用上传请求
     */
    @PostMapping("/common/upload")
    @ResponseBody
    public Object uploadFile(MultipartFile file) {

        // 上传并返回新文件名称
        String fileNamePath = null;
        try {
            fileNamePath = FileUploadUtils.upload(uploadPath, file);
            if (fileNamePath != null) {
                String url = serverConfig.getUrl() + fileNamePath;
                return ResultMsg.successData(url, "上传成功");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MaxUploadSizeExceededException e) {
            return ResultMsg.failureData(null, "文件太大");
        }

        return ResultMsg.failure("上传失败");
    }

    /**
     * 更具文件分类id查询文件
     * 默认进来查询全部文件
     *
     * @param typeId
     * @return
     */
    @RequestMapping("/common/queryFileUpload")
    @ResponseBody
    public Object getFileUplod(@RequestParam("typeId") Integer typeId) {
        List<FileUplod> fileUplods = fileUplodService.queryFileUplod(typeId);
        ResultInfo dataInfo = ResultInfo.dataInfo(0, fileUplods.size(), fileUplods);
        return dataInfo;
    }

    /**
     * 获取文件分类树
     *
     * @return
     */
    @RequestMapping("/common/queryFileType")
    @ResponseBody
    public Object getFileType(@RequestParam(name = "parentId", defaultValue = "0") Integer parentId) {
        List<TreeNode> treeNodes = fileUplodTypeService.queryFileUplodTypeByParentId(parentId);
        return treeNodes;
    }

    /**
     * 保存上传文件信息
     *
     * @param fileUplod
     * @return
     */
    public Object seavFile(FileUplod fileUplod) {
        return null;

    }
}
