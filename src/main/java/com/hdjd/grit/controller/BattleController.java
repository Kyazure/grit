package com.hdjd.grit.controller;

import com.hdjd.grit.core.ResultInfo;
import com.hdjd.grit.core.constant.ApiConstant;
import com.hdjd.grit.core.util.ResultInfoUtil;
import com.hdjd.grit.model.dto.ExtendBattle;
import com.hdjd.grit.model.pojo.Announcement;
import com.hdjd.grit.model.pojo.Battle;
import com.hdjd.grit.service.BattleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: yuan
 * @Date: 2020/3/27 12:43
 * @Version 1.0
 */
@CrossOrigin
@RestController
@RequestMapping("battle")
@Api(tags = "沙场相关接口")
public class BattleController {
    private final BattleService battleService;

    @Autowired
    public BattleController(BattleService battleService){
        this.battleService = battleService;
    }

    @GetMapping("")
    @ApiOperation(value = "获取所有沙场信息", notes="获取所有沙场信息")
    public List<ExtendBattle> getAll(){
        return battleService.getBattles();
    }

    @PostMapping("/insert")
    @ApiOperation(value = "新增沙场", notes="新增沙场")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "沙场名称",required = true, dataType = "string"),
            @ApiImplicitParam(name = "longitude", value = "经度",required = true, dataType = "string"),
            @ApiImplicitParam(name = "latitude", value = "纬度",required = true, dataType = "string"),
    })
    public ResultInfo<Battle> insert(Battle battle){
        Integer insert = battleService.insert(battle);
        return insert.intValue() == 0 ? ResultInfoUtil.buildError(ApiConstant.ERROR_CODE, "插入失败") : ResultInfoUtil.build(ApiConstant.SUCCESS_CODE, "插入成功", null);
    }

    @PutMapping("{id}")
    @ApiOperation(value = "修改沙场", notes="修改沙场")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "沙场名称", dataType = "string"),
            @ApiImplicitParam(name = "longitude", value = "经度", dataType = "string"),
            @ApiImplicitParam(name = "latitude", value = "纬度", dataType = "string"),
    })
    public ResultInfo<Battle> update(Battle battle, @PathVariable("id")String id){
        battle.setId(id);
        Integer insert = battleService.update(battle);
        return insert.intValue() == 0 ? ResultInfoUtil.buildError(ApiConstant.ERROR_CODE, "修改失败") : ResultInfoUtil.build(ApiConstant.SUCCESS_CODE, "修改成功", null);
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "根据id删除沙场", notes="根据id删除沙场")
    public ResultInfo<ExtendBattle> deleteAnnouncement(@PathVariable("id")String id){
        Integer integer = battleService.delete(id);
        return integer.intValue() == 0 ? ResultInfoUtil.buildError(ApiConstant.ERROR_CODE, "删除失败") : ResultInfoUtil.build(ApiConstant.SUCCESS_CODE, "删除成功", null);
    }
}
