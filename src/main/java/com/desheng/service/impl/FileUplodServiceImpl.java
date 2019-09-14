package com.desheng.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desheng.mapper.FileUplodMapper;
import com.desheng.pojo.FileUplod;
import com.desheng.pojo.FileUplodExample;
import com.desheng.service.file.FileUplodService;

import java.util.List;

@Service("fileUplodService")
public class FileUplodServiceImpl implements FileUplodService {
    @Autowired
    private FileUplodMapper fileUplodMapper;

    /**
     * 跟据分类条件查询文件
     *
     * @param fileTypeId 文件分类主键
     * @return
     */
    @Override
    public List<FileUplod> queryFileUplod(Integer fileTypeId) {
        if (fileTypeId != null) {
            FileUplodExample example = new FileUplodExample();
            example.createCriteria().andFileTypeIdEqualTo(fileTypeId);
            List<FileUplod> fileUplods = fileUplodMapper.selectByExample(example);
            return fileUplods;

        } else {
            List<FileUplod> fileUplods = fileUplodMapper.selectByExample(null);
            return fileUplods;
        }

    }
}
