package com.desheng.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.desheng.pojo.FileUplod;
import com.desheng.pojo.FileUplodExample;
import com.desheng.pojo.FileUplodKey;

public interface FileUplodMapper {
    long countByExample(FileUplodExample example);

    int deleteByExample(FileUplodExample example);

    int deleteByPrimaryKey(FileUplodKey key);

    int insert(FileUplod record);

    int insertSelective(FileUplod record);

    List<FileUplod> selectByExample(FileUplodExample example);

    FileUplod selectByPrimaryKey(FileUplodKey key);

    int updateByExampleSelective(@Param("record") FileUplod record, @Param("example") FileUplodExample example);

    int updateByExample(@Param("record") FileUplod record, @Param("example") FileUplodExample example);

    int updateByPrimaryKeySelective(FileUplod record);

    int updateByPrimaryKey(FileUplod record);
}