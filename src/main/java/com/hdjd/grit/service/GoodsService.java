package com.hdjd.grit.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hdjd.grit.core.exception.ParameterException;
import com.hdjd.grit.mapper.GoodsMapper;
import com.hdjd.grit.model.pojo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * @Author: yuan
 * @Date: 2020/3/4 18:44
 * @Version 1.0
 */
@Service
public class GoodsService {
    private final GoodsMapper goodsMapper;

    @Autowired
    public GoodsService(GoodsMapper goodsMapper){
        this.goodsMapper = goodsMapper;
    }

    public PageInfo<Goods> getGoodsForPage(Integer pageNum, Integer pageSize) {
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 5;
        }
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> goodsMapper.selectList(null));
    }

    @Transactional(rollbackFor = Exception.class)
    public Integer insertGood(Goods goods, String images){
        if (goods == null){
            throw new ParameterException("请输入你要加的商品信息");
        }
        String uuid = UUID.randomUUID().toString().replace("-", "");
        goods.setId(uuid);
        if (images == null) {
            goods.setImage("/images/goods/default.jpg");
            goods.setImage(System.getProperty("user.dir") + "/images/goods/default.jpg");
        } else {
            goods.setImage(images);
        }
        return goodsMapper.insert(goods);
    }

    @Transactional(rollbackFor = Exception.class)
    public Integer updateGood(Goods goods, String images){
        if (goods.getId() == null){
            throw new ParameterException("请选择一个商品操作");
        }
        if (images != null){
            goods.setImage(images);
        }
        return goodsMapper.updateById(goods);
    }

    @Transactional(rollbackFor = Exception.class)
    public Integer deleteGoodById(String id){
        if (id == null){
            throw new ParameterException("请选择一个商品操作");
        }
        return goodsMapper.deleteById(id);
    }

    public List<Goods> getGoodsByType(String type){
        if (type == null){
            throw new ParameterException("请选择一个类别操作");
        }
        Wrapper<Goods> wrapper = Wrappers.<Goods>lambdaQuery()
                .eq(Goods::getGoodsType, type);
        return goodsMapper.selectList(wrapper);
    }

}
