package com.desheng.service.file;

import java.util.List;

import com.desheng.vo.TreeNode;

public interface FileUplodTypeService {
    /**
     * 根据父id查询文件分类
     *
     * @param parentId 父id
     * @return
     */
    List<TreeNode> queryFileUplodTypeByParentId(Integer parentId);
}
