package com.desheng.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desheng.mapper.FileUplodTypeMapper;
import com.desheng.pojo.FileUplodType;
import com.desheng.pojo.FileUplodTypeExample;
import com.desheng.service.file.FileUplodTypeService;
import com.desheng.vo.TreeNode;

import java.util.ArrayList;
import java.util.List;

@Service("fileUplodTypeService")
public class FileUplodTypeServiceImpl implements FileUplodTypeService {

    @Autowired
    private FileUplodTypeMapper fileUplodTypeMapper;


    /**
     * 根据父id查询文件分类
     *
     * @param parentId 父id
     * @return
     */
    @Override
    public List<TreeNode> queryFileUplodTypeByParentId(Integer parentId) {
        FileUplodTypeExample example = new FileUplodTypeExample();
        example.createCriteria().andParentIdEqualTo(parentId);
        List<FileUplodType> fileUplodTypes = fileUplodTypeMapper.selectByExample(example);
        List<TreeNode> treeNodes = treeNodes(fileUplodTypes);
        return treeNodes;
    }

    //递归查询父节点
    private List<TreeNode> treeNodes(List<FileUplodType> fileUplodTypes) {
        List<TreeNode> treeNodes = new ArrayList<>();
        if (fileUplodTypes != null && fileUplodTypes.size() > 0) {
            for (FileUplodType fileUplodType : fileUplodTypes) {
                TreeNode treeNode = new TreeNode();
                treeNode.setTitle(fileUplodType.getFileType());
                treeNode.setId(fileUplodType.getId());
                treeNode.setChildren(queryFileUplodTypeByParentId(fileUplodType.getId()));
                treeNodes.add(treeNode);
            }
        }
        return treeNodes;
    }
}
