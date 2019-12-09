package com.offcn.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.offcn.dao.TbBrandMapper;
import com.offcn.pojo.TbBrand;
import com.offcn.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private TbBrandMapper brandMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    // 加入分页
    @Override
    public List<TbBrand> findAll() {
        PageHelper.startPage(1,3);
        List<TbBrand> brandList = brandMapper.selectByExample(null);
        PageInfo info = new PageInfo(brandList);
        List list = info.getList();
        redisTemplate.boundHashOps("cartList").put("rose",brandList);
        return brandList;
    }

    @Override
    public List<TbBrand> getRedis(String name) {
        List<TbBrand> list = (List<TbBrand>) redisTemplate.boundHashOps("cartList").get(name);
        return list;
    }
}
