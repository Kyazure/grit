package com.hdjd.grit.controller;

import com.github.pagehelper.PageInfo;
import com.hdjd.grit.core.ResultInfo;
import com.hdjd.grit.core.constant.ApiConstant;
import com.hdjd.grit.core.util.ResultInfoUtil;
import com.hdjd.grit.model.pojo.Announcement;
import com.hdjd.grit.service.AnnouncementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: yuan
 * @Date: 2020/3/5 10:34
 * @Version 1.0
 */
@CrossOrigin
@RestController
@RequestMapping("announcement")
@Api(tags = "公告模块相关接口")
public class AnnouncementController {
    private final AnnouncementService announcementService;

    @Autowired
    public AnnouncementController(AnnouncementService announcementService){
        this.announcementService = announcementService;
    }

    @GetMapping(path = {"a", "a/{pageNum}/{pageSize}", "a/{pageSize}"})
    @ApiOperation(value = "获取所有公告列表", notes="分页获取所有公告默认1页5个")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "分页页码"),
            @ApiImplicitParam(name = "pageSize", value = "分页条数"),
    })
    public PageInfo<Announcement> getGoodsForPage(@PathVariable(required = false) Integer pageNum,
                                                  @PathVariable(required = false)Integer pageSize){
        return announcementService.getAnnForPage(pageNum, pageSize);
    }

    @PostMapping("/insert")
    @ApiOperation(value = "新增公告", notes="新增公告")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title", value = "公告标题",required = true, dataType = "string"),
            @ApiImplicitParam(name = "content", value = "公告内容", dataType = "string"),
    })
    public ResultInfo<Announcement> insertAnnouncement(Announcement announcement){
        Integer integer = announcementService.insertAnnouncement(announcement);
        return integer.intValue() == 0 ? ResultInfoUtil.buildError(ApiConstant.ERROR_CODE, "插入失败") : ResultInfoUtil.build(ApiConstant.SUCCESS_CODE, "插入成功", null);
    }

    @PutMapping("{id}")
    @ApiOperation(value = "修改公告", notes="根据id修改公告")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title", value = "公告标题", dataType = "string"),
            @ApiImplicitParam(name = "content", value = "公告内容", dataType = "string"),
    })
    public ResultInfo<Announcement> updateAnnouncement(Announcement announcement, @PathVariable("id")String id){
        announcement.setId(id);
        Integer integer = announcementService.updateAnnouncement(announcement);
        return integer.intValue() == 0 ? ResultInfoUtil.buildError(ApiConstant.ERROR_CODE, "修改失败") : ResultInfoUtil.build(ApiConstant.SUCCESS_CODE, "修改成功", null);
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "根据id删除评论", notes="删除公告")
    @ApiImplicitParam(name = "id", value = "商品id", required = true, dataType = "string")
    public ResultInfo<Announcement> deleteAnnouncement(@PathVariable("id")String id){
        Integer integer = announcementService.deleteAnnouncement(id);
        return integer.intValue() == 0 ? ResultInfoUtil.buildError(ApiConstant.ERROR_CODE, "删除失败") : ResultInfoUtil.build(ApiConstant.SUCCESS_CODE, "删除成功", null);
    }
}
