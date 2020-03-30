package com.hdjd.grit.controller;

import com.github.pagehelper.PageInfo;
import com.hdjd.grit.core.ResultInfo;
import com.hdjd.grit.core.constant.ApiConstant;
import com.hdjd.grit.core.util.IsImageUntill;
import com.hdjd.grit.core.util.ResultInfoUtil;
import com.hdjd.grit.model.pojo.Goods;
import com.hdjd.grit.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @Author: yuan
 * @Date: 2020/3/4 19:25
 * @Version 1.0
 */
@CrossOrigin
@RestController
@RequestMapping("goods")
@Api(tags = "商品相关接口")
public class GoodsController {
    private final GoodsService goodsService;

    @Autowired
    public GoodsController(GoodsService goodsService){
        this.goodsService = goodsService;
    }

    @GetMapping(path = {"g", "g/{pageNum}/{pageSize}", "g/{pageSize}"})
    @ApiOperation(value = "获取所有商品列表", notes="分页获取所有商品默认1页5个")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "分页页码"),
            @ApiImplicitParam(name = "pageSize", value = "分页条数"),
    })
    public PageInfo<Goods> getGoodsForPage(@PathVariable(required = false) Integer pageNum,
                                           @PathVariable(required = false)Integer pageSize){
        return goodsService.getGoodsForPage(pageNum, pageSize);
    }

    @PostMapping("/insert")
    @ApiOperation(value = "新增商品", notes="新增商品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "goodsName", value = "商品名称", required = true, dataType = "string"),
            @ApiImplicitParam(name = "salePrice", value = "单价", required = true, dataType = "float"),
            @ApiImplicitParam(name = "amount", value = "库存数量", required = true,  dataType = "float"),
            @ApiImplicitParam(name = "monthySales", value = "月销量", required = true, dataType = "float"),
            @ApiImplicitParam(name = "note", value = "商品说明", required = true, dataType = "string"),
            @ApiImplicitParam(name = "deliverCost", value = "配送费", required = true, dataType = "float"),
            @ApiImplicitParam(name = "file", value = "商品图片", dataType = "_file"),
            @ApiImplicitParam(name = "goodsType", value = "商品类型", required = true, dataType = "string"),
            @ApiImplicitParam(name = "unit", value = "商品计数单位", required = true, dataType = "string")
    })
    public ResultInfo<Goods> insertGood(MultipartFile file, Goods goods) throws IOException {
        String imges = null;
        if (file != null && IsImageUntill.isImage(file.getOriginalFilename())) {
            String filename = Optional.ofNullable(file.getOriginalFilename()).orElse("");
            String rootPath = System.getProperty("user.dir");
            String fileName = "/images/goods/" + UUID.randomUUID().toString() + filename.substring(filename.lastIndexOf("."));
            file.transferTo(new File(rootPath + fileName));
            imges = fileName;
        }
        Integer integer = goodsService.insertGood(goods, imges);
        return integer.intValue() == 0 ? ResultInfoUtil.buildError(ApiConstant.ERROR_CODE, "插入失败") : ResultInfoUtil.build(ApiConstant.SUCCESS_CODE, "插入成功", null);
    }

    @PutMapping("{id}")
    @ApiOperation(value = "根据id修改商品", notes="修改商品信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "goodsName", value = "商品名称", dataType = "string"),
            @ApiImplicitParam(name = "salePrice", value = "单价", required = false, dataType = "float"),
            @ApiImplicitParam(name = "amount", value = "库存数量", required = false, dataType = "float"),
            @ApiImplicitParam(name = "monthySales", value = "月销量", required = false, dataType = "float"),
            @ApiImplicitParam(name = "note", value = "商品说明", required = false, dataType = "string"),
            @ApiImplicitParam(name = "deliverCost", value = "配送费", required = false, dataType = "float"),
            @ApiImplicitParam(name = "file", value = "商品图片", required = false, dataType = "_file"),
            @ApiImplicitParam(name = "goodsType", value = "商品类型", required = false, dataType = "string"),
            @ApiImplicitParam(name = "unit", value = "商品计数单位", required = false, dataType = "string")
    })
    public ResultInfo<Goods> updateGood(MultipartFile file, Goods goods, @PathVariable("id")String id) throws IOException {
        goods.setId(id);
        String imges = null;
        if (file != null && IsImageUntill.isImage(file.getOriginalFilename())) {
            String filename = Optional.ofNullable(file.getOriginalFilename()).orElse("");
            String rootPath = System.getProperty("user.dir");
            String fileName = "/images/goods/" + UUID.randomUUID().toString() + filename.substring(filename.lastIndexOf("."));
            file.transferTo(new File(rootPath + fileName));
            imges = fileName;
        }
        Integer integer = goodsService.updateGood(goods, imges);
        return integer.intValue() == 0 ? ResultInfoUtil.buildError(ApiConstant.ERROR_CODE, "修改失败") : ResultInfoUtil.build(ApiConstant.SUCCESS_CODE, "修改成功", null);
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "根据id删除商品", notes="删除商品信息")
    @ApiImplicitParam(name = "id", value = "商品id", required = true, dataType = "string")
    public ResultInfo<Goods> deleteGood(@PathVariable("id")String id){
        Integer integer = goodsService.deleteGoodById(id);
        return integer.intValue() == 0 ? ResultInfoUtil.buildError(ApiConstant.ERROR_CODE, "删除失败") : ResultInfoUtil.build(ApiConstant.SUCCESS_CODE, "删除成功", null);
    }

    @GetMapping("/type")
    @ApiOperation(value = "根据商品类别获取商品列表", notes="根据商品类别获取商品列表")
    @ApiImplicitParam(name = "type", value = "商品类别", required = true, dataType = "string")
    public List<Goods> getGoodsByType(@RequestParam String type){
        return goodsService.getGoodsByType(type);
    }


}
