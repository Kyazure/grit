package com.hdjd.grit.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hdjd.grit.core.exception.ParameterException;
import com.hdjd.grit.core.util.ListSub;
import com.hdjd.grit.mapper.GoodsMapper;
import com.hdjd.grit.mapper.OrdersAndGoodsMapper;
import com.hdjd.grit.mapper.OrdersMapper;
import com.hdjd.grit.model.dto.ExtenOrders;
import com.hdjd.grit.model.dto.ExtendGoods;
import com.hdjd.grit.model.pojo.Goods;
import com.hdjd.grit.model.pojo.Orders;
import com.hdjd.grit.model.pojo.OrdersAndGoods;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: yuan
 * @Date: 2020/3/5 17:30
 * @Version 1.0
 */
@Service
public class OrdersService {
    private final OrdersMapper ordersMapper;
    private final GoodsMapper goodsMapper;
    private final OrdersAndGoodsMapper ordersAndGoodsMapper;

    @Autowired
    public OrdersService(OrdersMapper ordersMapper, GoodsMapper goodsMapper, OrdersAndGoodsMapper ordersAndGoodsMapper){
        this.ordersMapper = ordersMapper;
        this.goodsMapper = goodsMapper;
        this.ordersAndGoodsMapper = ordersAndGoodsMapper;
    }

    public ListSub<ExtenOrders> getOrdersForPage(Integer pageNum, Integer pageSize){
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 5;
        }

        ArrayList<ExtenOrders> list = new ArrayList<>();
        Wrapper<Orders> wrapper1 = Wrappers.<Orders>lambdaQuery()
                .eq(Orders::getIsDelete, (byte)0)
                .orderByDesc(Orders::getCreateTime);
        List<Orders> orders = ordersMapper.selectList(wrapper1);

        orders.forEach(orders1 -> {
            ExtenOrders extenOrders = new ExtenOrders();
            BeanUtils.copyProperties(orders1, extenOrders);
            Wrapper<OrdersAndGoods> wrapper2 = Wrappers.<OrdersAndGoods>lambdaQuery()
                    .eq(OrdersAndGoods::getOrdersId, orders1.getId());
            List<OrdersAndGoods> ordersAndGoods = ordersAndGoodsMapper.selectList(wrapper2);
            ordersAndGoods.forEach(ordersAndGoods1 -> {
                ExtendGoods extendGoods = new ExtendGoods();
                extendGoods.setGoods(goodsMapper.selectById(ordersAndGoods1.getGoodsId()));
                extendGoods.setNum(ordersAndGoods1.getPurchaseQuantity());
                extenOrders.getExtendGoods().add(extendGoods);
            });
            list.add(extenOrders);
        });
        ListSub<ExtenOrders> listSub = new ListSub<ExtenOrders>(pageNum, pageSize, list);
        listSub.getPageNum();
        listSub.getPages();
        listSub.getTotal();
        listSub.getPageSize();
        return listSub;
    }

    @Transactional(rollbackFor = Exception.class)
    public Integer deleteOrderById(String id){
        if (id == null){
            throw new ParameterException("请选择一个商品操作");
        }
        Wrapper<OrdersAndGoods> wrapper = Wrappers.<OrdersAndGoods>lambdaQuery()
                .eq(OrdersAndGoods::getOrdersId, id);
        ordersAndGoodsMapper.delete(wrapper);
        Orders order = Orders.builder().id(id).isDelete((byte)1).build();
        return ordersMapper.updateById(order);
    }

    @Transactional(rollbackFor = Exception.class)
    public Integer insertOrder(ExtenOrders extenOrders){
        String orderId = UUID.randomUUID().toString().replace("-", "");
        Orders orders = new Orders();
        BeanUtils.copyProperties(extenOrders, orders);
        orders.setId(orderId);
        if (extenOrders.getProtocolUrl() == null){
            orders.setProtocolUrl("/images/order/default.jpg");
        }
        Calendar calendar = Calendar.getInstance();
        orders.setCreateTime(calendar.getTime());
        extenOrders.getExtendGoods().forEach(extendGoods -> {
            String goodsAndOrderId = UUID.randomUUID().toString().replace("-", "");
            OrdersAndGoods ordersAndGoods = OrdersAndGoods.builder().id(goodsAndOrderId).ordersId(orderId)
                    .goodsId(extendGoods.getGoods().getId()).purchaseQuantity(extendGoods.getNum()).build();
            ordersAndGoodsMapper.insert(ordersAndGoods);
        });
        return ordersMapper.insert(orders);
    }
    @Transactional(rollbackFor = Exception.class)
    public Integer updateOrder(ExtenOrders extenOrders){
        if (extenOrders.getId() == null){
            throw new ParameterException("请选择一个订单");
        }
        Orders orders = Orders.builder().id(extenOrders.getId()).status(extenOrders.getStatus()).build();
        if (extenOrders.getStatus().equals("预约成功")){
            Wrapper<OrdersAndGoods> wrapper1 = Wrappers.<OrdersAndGoods>lambdaQuery()
                    .eq(OrdersAndGoods::getOrdersId, orders.getId());
            List<OrdersAndGoods> ordersAndGoods = ordersAndGoodsMapper.selectList(wrapper1);
            ordersAndGoods.forEach(ordersAndGoods1 -> {
                Wrapper<Goods> wrapper2 = Wrappers.<Goods>lambdaQuery()
                        .eq(Goods::getId, ordersAndGoods1.getGoodsId());
                Goods goods = goodsMapper.selectOne(wrapper2);
                goods.setAmount(goods.getAmount() - ordersAndGoods1.getPurchaseQuantity());
                goodsMapper.updateById(goods);
            });
        }
        return ordersMapper.updateById(orders);
    }

    public List<ExtenOrders> getOrdersByUserId(String userId){
        List<ExtenOrders> list = new LinkedList<>();
        Wrapper<Orders> wrapper1 = Wrappers.<Orders>lambdaQuery()
                .eq(Orders::getIsDelete, (byte)0)
                .eq(Orders::getUserId, userId)
                .orderByDesc(Orders::getCreateTime);
        List<Orders> orders = ordersMapper.selectList(wrapper1);
        orders.forEach(orders1 -> {
            ExtenOrders extenOrders = new ExtenOrders();
            BeanUtils.copyProperties(orders1, extenOrders);
            Wrapper<OrdersAndGoods> wrapper2 = Wrappers.<OrdersAndGoods>lambdaQuery()
                    .eq(OrdersAndGoods::getOrdersId, orders1.getId());
            List<OrdersAndGoods> ordersAndGoods = ordersAndGoodsMapper.selectList(wrapper2);
            ordersAndGoods.forEach(ordersAndGoods1 -> {
                ExtendGoods extendGoods = new ExtendGoods();
                extendGoods.setGoods(goodsMapper.selectById(ordersAndGoods1.getGoodsId()));
                extendGoods.setNum(ordersAndGoods1.getPurchaseQuantity());
                extenOrders.getExtendGoods().add(extendGoods);
            });
            list.add(extenOrders);
        });
        return list;
    }

    @Transactional(rollbackFor = Exception.class)
    public Integer cancelOrder(ExtenOrders extenOrders){
        if (extenOrders.getId() == null){
            throw new ParameterException("请输入操作的订单");
        }
        Orders order = Orders.builder().id(extenOrders.getId()).cancelReason(extenOrders.getCancelReason()).status("已取消").build();
        return ordersMapper.updateById(order);
    }

    public Integer[] getOrders(Date date){
        if (date == null){
            throw new ParameterException("请输入日期");
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = new GregorianCalendar();
        Integer[] result = new Integer[7];
        for (int i = 0; i < 7; i++) {
            calendar.setTime(date);
            calendar.add(Calendar.DATE, 1);
            date = calendar.getTime();
            System.out.println(simpleDateFormat.format(date));
            result[i] = ordersMapper.getOrders(simpleDateFormat.format(date));
        }
        return result;
    }
}
