package com.offcn.service;

import com.offcn.pojo.TbBrand;

import java.util.List;

public interface BrandService {

    List<TbBrand> findAll();

    List<TbBrand> getRedis(String name);
}
