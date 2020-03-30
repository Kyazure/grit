package com.hdjd.grit.controller;

import com.github.pagehelper.PageInfo;
import com.hdjd.grit.core.ResultInfo;
import com.hdjd.grit.core.constant.ApiConstant;
import com.hdjd.grit.core.util.IsImageUntill;
import com.hdjd.grit.core.util.ListSub;
import com.hdjd.grit.core.util.ResultInfoUtil;
import com.hdjd.grit.model.dto.ExtenOrders;
import com.hdjd.grit.model.pojo.Orders;
import com.hdjd.grit.service.OrdersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @Author: yuan
 * @Date: 2020/3/5 17:46
 * @Version 1.0
 */
@CrossOrigin
@RestController
@RequestMapping("orders")
@Api(tags = "订单相关接口")
public class OrdersController {
    private final OrdersService ordersService;

    @Autowired
    public OrdersController(OrdersService ordersService){
        this.ordersService = ordersService;
    }

    @GetMapping(path = {"o", "o/{pageNum}/{pageSize}", "o/{pageSize}"})
    @ApiOperation(value = "获取所有订单", notes="分页获取所有订单默认1页5个")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "分页页码"),
            @ApiImplicitParam(name = "pageSize", value = "分页条数"),
    })
    public ListSub<ExtenOrders> getOrdersForPage(@PathVariable(required = false) Integer pageNum,
                                                 @PathVariable(required = false)Integer pageSize){
        return ordersService.getOrdersForPage(pageNum,  pageSize);
    }

    @GetMapping("{id}")
    @ApiOperation(value = "获取指定用户的所有订单", notes="获取指定用户的所有订单信息")
    public List<ExtenOrders> getOrdersByUser(@PathVariable("id")String id){
        return ordersService.getOrdersByUserId(id);
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "根据id删除订单", notes="删除订单信息")
    @ApiImplicitParam(name = "id", value = "订单id", required = true, dataType = "string")
    public ResultInfo<ExtenOrders> deleteOrder(@PathVariable("id")String id){
        Integer integer = ordersService.deleteOrderById(id);
        return integer.intValue() == 0 ? ResultInfoUtil.buildError(ApiConstant.ERROR_CODE, "删除失败") : ResultInfoUtil.build(ApiConstant.SUCCESS_CODE, "删除成功", null);
    }

    @PostMapping("/insert")
    @ApiOperation(value = "新增订单", notes="新增订单信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "string"),
            @ApiImplicitParam(name = "deliveryTime", value = "配送时间", required = true, dataType = "date-time"),
            @ApiImplicitParam(name = "deliveryAddress", value = "配送详细地址", required = true, dataType = "string"),
            @ApiImplicitParam(name = "contactName", value = "联系人姓名", required = true, dataType = "string"),
            @ApiImplicitParam(name = "contactPhone", value = "联系人联系方式", required = true, dataType = "string"),
            @ApiImplicitParam(name = "buildingNature", value = "楼房性质", required = true, dataType = "string"),
            @ApiImplicitParam(name = "propertyNature", value = "楼房性质", required = true, dataType = "string"),
            @ApiImplicitParam(name = "remark", value = "订单说明", dataType = "sting"),
            @ApiImplicitParam(name = "carType", value = "配送车类别", required = true, dataType = "string"),
            @ApiImplicitParam(name = "distance", value = "配送距离", required = true, dataType = "float"),
            @ApiImplicitParam(name = "extendGoods", value = "商品集合以及购买的数量", required = true),
            @ApiImplicitParam(name = "totalAmount", value = "总金额", required = true, dataType = "float"),
            @ApiImplicitParam(name = "distributionPoint", value = "配送点", required = true, dataType = "string"),
    })
    public ResultInfo<ExtenOrders> insertOrder(@RequestBody ExtenOrders extenOrders) {
        Integer integer = ordersService.insertOrder(extenOrders);
        return integer.intValue() == 0 ? ResultInfoUtil.buildError(ApiConstant.ERROR_CODE, "插入失败") : ResultInfoUtil.build(ApiConstant.SUCCESS_CODE, "插入成功", null);
    }

    @PostMapping("/upload")
    @ApiOperation(value = "图片上传", notes="图片上传")
    public String upload(MultipartFile file) throws IOException {
        String imges = null;
        if (file != null && IsImageUntill.isImage(file.getOriginalFilename())) {
            String filename = Optional.ofNullable(file.getOriginalFilename()).orElse("");
            String rootPath = System.getProperty("user.dir");
            String fileName = "/images/order/" + UUID.randomUUID().toString() + filename.substring(filename.lastIndexOf("."));
            file.transferTo(new File(rootPath + fileName));
            imges = fileName;
        }
        return imges;
    }
    @PutMapping("{id}")
    @ApiOperation(value = "审批订单", notes="修改订单的状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "status", required = true, dataType = "string"),
    })
    public ResultInfo<ExtenOrders> updateOrderStatus(ExtenOrders extenOrders, @PathVariable("id")String id){
        extenOrders.setId(id);
        Integer integer = ordersService.updateOrder(extenOrders);
        return integer.intValue() == 0 ? ResultInfoUtil.buildError(ApiConstant.ERROR_CODE, "修改失败") : ResultInfoUtil.build(ApiConstant.SUCCESS_CODE, "修改成功", null);
    }

    @PutMapping("/cancel/{id}")
    @ApiOperation(value = "取消订单", notes="取消订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cancelReason", required = true, dataType = "string"),
    })
    public ResultInfo<ExtenOrders> cancelOrder(ExtenOrders extenOrders, @PathVariable("id")String id){
        extenOrders.setId(id);
        Integer integer = ordersService.cancelOrder(extenOrders);
        return integer.intValue() == 0 ? ResultInfoUtil.buildError(ApiConstant.ERROR_CODE, "取消失败") : ResultInfoUtil.build(ApiConstant.SUCCESS_CODE, "取消成功", null);
    }

    @GetMapping("/getOrders")
    @ApiOperation(value = "获取订单安排", notes = "获取订单安排")
    public Integer[] getOrders(){
        Date date = new Date();
        return ordersService.getOrders(date);
    }
}
