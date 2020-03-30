package com.hdjd.grit.service;

import com.hdjd.grit.controller.OrdersController;
import com.hdjd.grit.core.ResultInfo;
import com.hdjd.grit.core.util.ListSub;
import com.hdjd.grit.model.dto.ExtenOrders;
import com.hdjd.grit.model.dto.ExtendGoods;
import com.hdjd.grit.model.pojo.Goods;
import com.hdjd.grit.model.pojo.Orders;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.*;

/**
 * @Author: yuan
 * @Date: 2020/3/6 12:16
 * @Version 1.0
 */
@SpringBootTest
public class OrderServiceTest {
    @Autowired
    OrdersService ordersService;
    @Autowired
    OrdersController ordersController;

    @Test
    public void getOrders() throws IOException {
        ListSub<ExtenOrders> ordersForPage = ordersController.getOrdersForPage(1, 5);
        ordersForPage.getList().forEach(list->{
            System.out.println(list.getCreateTime());
        });
    }
}
