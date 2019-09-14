package com.desheng.service.file;

import java.util.List;

import com.desheng.pojo.FileUplod;

public interface FileUplodService {
    /**
     * 跟据分类条件查询文件
     *
     * @param fileTypeId 文件分类主键
     * @return
     */
    List<FileUplod> queryFileUplod(Integer fileTypeId);

}
