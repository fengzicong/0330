package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.common.pojo.PageResult;
import com.pinyougou.pojo.Brand;
import com.pinyougou.service.BrandService;

import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {
    /**
     * 引用服务接口代理对象
     * timeout: 调用服务接口方法超时时间毫秒数
     */
    @Reference(timeout = 10000 )
    private BrandService brandService;

    /** 查询全部品牌 */
    @GetMapping("/findAll")
    public List<Brand> findAll(){
        return brandService.findAll();
    }
    @GetMapping("/findByPage")
    //要返回的数据:1.brands集合;2总记录数; {total:xxx, rows :[{},{}]}
    public PageResult findByPage(Brand brand,Integer page,Integer rows){
        try {
            brand.setName(new String(brand.getName()
                    .getBytes("ISO8859-1"), "UTF-8"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return brandService.findByPage(brand, page, rows);
    }

    @PostMapping("/save")
    public boolean save(@RequestBody Brand brand){
        try {
            brandService.save(brand);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @PostMapping("/update")
    public boolean update(@RequestBody Brand brand){
        try {
            brandService.update(brand);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @GetMapping("/delete")
    public boolean delete(Long[] ids){
        try {
            brandService.deleteAll(ids);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
