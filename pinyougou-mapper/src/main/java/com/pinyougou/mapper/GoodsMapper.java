package com.pinyougou.mapper;

import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import com.pinyougou.pojo.Goods;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * GoodsMapper 数据访问接口
 * @date 2019-03-28 19:11:39
 * @version 1.0
 */
public interface GoodsMapper extends Mapper<Goods>{


    List<Map<String,Object>> findAll(Goods goods);

    void updateStatus(@Param("status") String status, @Param("ids") Long[] ids);


    void updateIsDelete(@Param("ids") Long[] ids);

    void updateMarketable(@Param("status") String status, @Param("ids") Long[] ids);

}