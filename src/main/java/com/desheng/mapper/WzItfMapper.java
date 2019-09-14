package com.desheng.mapper;

import com.desheng.pojo.WzItf;
import com.desheng.pojo.WzItfExample;
import com.desheng.vo.WzItfVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface WzItfMapper {
    long countByExample(WzItfExample example);

    int deleteByExample(WzItfExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WzItf record);

    int insertSelective(WzItf record);

    List<WzItf> selectByExample(WzItfExample example);

    @Select("select c.* from wz_itf t INNER join wz_workline c on c.wz_itf_id=t.id order by c.point_slicer ")
    List<Map<String, Object>> selectByTimeOut();


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