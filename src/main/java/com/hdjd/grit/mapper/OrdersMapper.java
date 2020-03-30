package com.hdjd.grit.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hdjd.grit.model.dto.ExtenOrders;
import com.hdjd.grit.model.pojo.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: yuan
 * @Date: 2020/3/5 17:28
 * @Version 1.0
 */
@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {
    @Select("SELECT COUNT(*) FROM orders WHERE orders.delivery_time=#{date} and orders.is_delete = 0 and orders.`status` in ('预约成功','配送中','预约中')")
    Integer getOrders(@Param("date") String date);
}
