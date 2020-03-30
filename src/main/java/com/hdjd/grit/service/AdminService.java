package com.hdjd.grit.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hdjd.grit.mapper.AdminMapper;
import com.hdjd.grit.model.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: yuan
 * @Date: 2020/3/4 17:17
 * @Version 1.0
 */
@Service
public class AdminService {
    private final AdminMapper adminMapper;

    @Autowired
    public AdminService(AdminMapper adminMapper){
        this.adminMapper = adminMapper;
    }

    public Admin getAdminByName(String adminName){
        Wrapper<Admin> wrapper = Wrappers.<Admin>lambdaQuery()
                .eq(Admin::getName, adminName);
        return adminMapper.selectOne(wrapper);
    }

    public Admin getAdminByNameAndPassword(String adminName, String password){
        Wrapper<Admin> wrapper = Wrappers.<Admin>lambdaQuery()
                .eq(Admin::getName, adminName)
                .eq(Admin::getPassword, password);
        return adminMapper.selectOne(wrapper);
    }
}
