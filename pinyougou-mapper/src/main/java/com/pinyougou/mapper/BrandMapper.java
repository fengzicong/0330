package com.pinyougou.mapper;

import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import com.pinyougou.pojo.Brand;

import java.util.List;
import java.util.Map;

/**
 * BrandMapper 数据访问接口
 * @date 2019-03-28 19:11:39
 * @version 1.0
 */
public interface BrandMapper extends Mapper<Brand>{


    List<Brand> findAll(Brand brand);

    @Select("select id,name as 'text'  FROM tb_brand order by id asc")
    List<Map<String,Object>> findAllByIdAndName();
}