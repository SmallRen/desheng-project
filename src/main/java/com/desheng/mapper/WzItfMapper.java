package com.desheng.mapper;

import com.desheng.pojo.WzItf;
import com.desheng.pojo.WzItfExample;

import java.util.List;

import com.desheng.vo.WzItfVo;
import org.apache.ibatis.annotations.Param;

public interface WzItfMapper {
    long countByExample(WzItfExample example);

    int deleteByExample(WzItfExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WzItf record);

    int insertSelective(WzItf record);

    List<WzItf> selectByExample(WzItfExample example);

    /**
     * 自己扩展
     *
     * @param example
     * @return
     */
    List<WzItfVo> selectByExampleVo(WzItfExample example);

    WzItf selectByPrimaryKey(Integer id);

    WzItfVo selectByPrimaryKeyVo(Integer id);

    int updateByExampleSelective(@Param("record") WzItf record, @Param("example") WzItfExample example);

    int updateByExample(@Param("record") WzItf record, @Param("example") WzItfExample example);

    int updateByPrimaryKeySelective(WzItf record);

    int updateByPrimaryKey(WzItf record);
}