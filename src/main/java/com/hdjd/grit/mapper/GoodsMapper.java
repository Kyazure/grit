package com.hdjd.grit.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hdjd.grit.model.dto.ExtendGoods;
import com.hdjd.grit.model.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: yuan
 * @Date: 2020/3/4 18:43
 * @Version 1.0
 */
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {
}
