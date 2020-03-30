package com.hdjd.grit.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hdjd.grit.core.exception.ParameterException;
import com.hdjd.grit.mapper.AnnouncementMapper;
import com.hdjd.grit.model.pojo.Announcement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.UUID;

/**
 * @Author: yuan
 * @Date: 2020/3/5 10:30
 * @Version 1.0
 */
@Service
public class AnnouncementService {
    private final AnnouncementMapper announcementMapper;

    @Autowired
    public AnnouncementService(AnnouncementMapper announcementMapper){
        this.announcementMapper = announcementMapper;
    }

    @Transactional(rollbackFor = Exception.class)
    public Integer insertAnnouncement(Announcement announcement){
        String uuid = UUID.randomUUID().toString().replace("-", "");
        Calendar calendar = Calendar.getInstance();
        announcement.setCreateTime(calendar.getTime());
        announcement.setId(uuid);
        return announcementMapper.insert(announcement);
    }
    @Transactional(rollbackFor = Exception.class)
    public Integer deleteAnnouncement(String id){
        if (id == null){
            throw  new ParameterException("参数异常");
        }
        return announcementMapper.deleteById(id);
    }
    @Transactional(rollbackFor = Exception.class)
    public Integer updateAnnouncement(Announcement announcement){
        if (announcement.getId() == null){
            throw new ParameterException("参数异常");
        }
        Calendar calendar = Calendar.getInstance();
        announcement.setUpdateTime(calendar.getTime());
        return announcementMapper.updateById(announcement);
    }
    public PageInfo<Announcement> getAnnForPage(Integer pageNum, Integer pageSize) {
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 5;
        }
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> announcementMapper.selectList(null));
    }
}
