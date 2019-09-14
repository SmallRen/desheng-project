package com.desheng.service.impl;

import com.desheng.mapper.WzPointProductMapper;
import com.desheng.mapper.WzProductMapper;
import com.desheng.pojo.WzProduct;
import com.desheng.pojo.WzProductExample;
import com.desheng.service.wzgd.WzProductService;
import com.desheng.vo.WzPointProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("wzProductService")
public class WzProductServiceImpl implements WzProductService {
    @Autowired
    private WzProductMapper wzProductMapper;

    @Autowired
    private WzPointProductMapper wzPointProductMapper;

    @Override
    public List<WzProduct> queryWzProductAll() {
        List<WzProduct> wzProducts = wzProductMapper.selectByExample(null);
        return wzProducts;
    }

    @Override
    public List<WzProduct> queryWzProductByName(String name) {
        if (name == null) {
            List<WzProduct> wzProducts = wzProductMapper.selectByExample(null);
            return wzProducts;
        }
        WzProductExample example = new WzProductExample();
        example.createCriteria().andWzNameLike("%" + name + "%");
        List<WzProduct> wzProducts = wzProductMapper.selectByExample(example);
        return wzProducts;
    }

    @Override
    public List<Map<String, Object>> queryWzPointByScode(String scode) {
        List<Map<String, Object>> maps = wzPointProductMapper.queryWzPointByScode(scode);
        wzPointProductMapper.queryWzPointByScode(scode);

        return maps;
    }
}
