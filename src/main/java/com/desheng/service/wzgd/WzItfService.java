package com.desheng.service.wzgd;

import com.desheng.pojo.WzItf;
import com.desheng.pojo.WzItfDetailed;
import com.desheng.pojo.WzWorkLine;
import com.desheng.vo.WzItfVo;

import java.util.List;
import java.util.Map;

public interface WzItfService {
    /**
     * 新增物资工单
     *
     * @param wzItf 工单信息 里面包含物资信息
     * @return
     */
    Map<String, Object> addNewWzItf(WzItf wzItf) throws Exception;

    /**
     * 查询工单列表
     *
     * @return
     */
    List<WzItfVo> queryWzItfAll();

    /**
     * 根据工单列表id 查询对应的物资信息
     *
     * @param id 工单列表id
     * @return
     */
    List<WzItfDetailed> queryWzItDetailedById(Integer id);

    /**
     * 根据工单列表id 查询对应的线路信息
     *
     * @param id 工单列表id
     * @return
     */
    List<WzWorkLine> queryWzWorkLineById(Integer id);

    /**
     * 根据工单id查询工单信息
     *
     * @param id
     * @return
     */
    WzItfVo queryWzItfById(Integer id);

    /**
     * 进行工单超时查询并发送超时消息
     */
    void executeTimeOut();
}
