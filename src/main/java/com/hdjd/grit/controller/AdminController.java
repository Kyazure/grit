package com.hdjd.grit.controller;

import com.github.pagehelper.PageInfo;
import com.hdjd.grit.core.ResultInfo;
import com.hdjd.grit.core.constant.ApiConstant;
import com.hdjd.grit.core.util.ResultInfoUtil;
import com.hdjd.grit.model.pojo.Admin;
import com.hdjd.grit.model.pojo.Goods;
import com.hdjd.grit.service.AdminService;
import com.hdjd.grit.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @Author: yuan
 * @Date: 2020/3/4 17:18
 * @Version 1.0
 */
@CrossOrigin
@RestController
@RequestMapping("admin")
@Api(tags = "管理员相关接口")
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService){
        this.adminService = adminService;
}

    @PostMapping("/login")
    @ApiOperation(value = "管理员登录", notes="通过管理员用户名和密码登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "adminName", value = "用户名", required = true, dataType = "string"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "string")
    })
    public ResultInfo<Admin> login(@RequestParam String adminName, @RequestParam String password, HttpSession session){
        Admin adminByName = adminService.getAdminByName(adminName);
        if (adminByName == null){
            return ResultInfoUtil.buildError(ApiConstant.ERROR_CODE, "用户名错误");
        }else {
            Admin adminByNameAndPassword = adminService.getAdminByNameAndPassword(adminName, password);
            if (adminByNameAndPassword == null){
                return ResultInfoUtil.buildError(ApiConstant.ERROR_CODE, "密码错误");
            }else {
                session.setAttribute("admin", adminByNameAndPassword);
                return ResultInfoUtil.build(ApiConstant.SUCCESS_CODE, "登录成功", adminByNameAndPassword);
            }
        }
    }

    @GetMapping("/logout")
    @ApiOperation(value = "管理员退出登录", notes="退出登录")
    public ResultInfo<Admin> logout(HttpSession session) {
        Admin admin = (Admin)session.getAttribute("admin");
        if (admin == null) {
            return ResultInfoUtil.buildError(ApiConstant.ERROR_CODE, "请先登录");
        }
        session.removeAttribute("admin");
        return ResultInfoUtil.build(ApiConstant.SUCCESS_CODE, "退出成功", null);
    }




}
