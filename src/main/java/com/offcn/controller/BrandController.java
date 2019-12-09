package com.offcn.controller;

import com.offcn.pojo.TbBrand;
import com.offcn.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BrandController {

    @Autowired
    private BrandService brandService;

    @RequestMapping("/findAll")
    public List<TbBrand> findAll(){
        return brandService.findAll();
    }

    @RequestMapping("/getRedis")
    public  List<TbBrand> getRedis(){
       return  brandService.getRedis("rose");
    }
    @ReqestMapping("/test")
    public vod test(){
        System.out.println("嘻嘻");
    }
}
