package com.desheng.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.desheng.pojo.FileUplodType;
import com.desheng.pojo.FileUplodTypeExample;

public interface FileUplodTypeMapper {
    long countByExample(FileUplodTypeExample example);

    int deleteByExample(FileUplodTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FileUplodType record);

    int insertSelective(FileUplodType record);

    List<FileUplodType> selectByExample(FileUplodTypeExample example);

    FileUplodType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FileUplodType record, @Param("example") FileUplodTypeExample example);

    int updateByExample(@Param("record") FileUplodType record, @Param("example") FileUplodTypeExample example);

    int updateByPrimaryKeySelective(FileUplodType record);

    int updateByPrimaryKey(FileUplodType record);
}