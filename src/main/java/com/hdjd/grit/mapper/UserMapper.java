package com.hdjd.grit.mapper;

import com.hdjd.grit.model.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yeqi
 */
@Mapper
public interface UserMapper {


    /**
     * 通过微信open_id获取用户id
     *
     * @param openId 微信用户id
     * @return 用户id
     */
    @Select("select id from user where wechat_id = #{openId}")
    String getUserIdByWeChatId(String openId);


    /**
     * 插入用户的微信id信息
     *
     * @param user 用户的Id 及WeChat_id
     * @return 是否插入成功
     */
    @Insert("insert into user (id,name,telephone,avatar_url,wechat_id) values (#{id},#{name},#{telephone},#{avatarUrl},#{wechatId})")
    int insertWeChatUserIds(User user);

    /**
     * 通过id更新用户基本信息
     * @param user 用户信息
     * @return 更新的条数
     */
    @UpdateProvider(type = UserMapperProvider.class,method = "updateUserByIdSql")
    int updateUserById(User user);

    /**
     * 通过id获取用户基本信息
     *
     * @param id 用户Id
     * @return 用户信息
     */
    @Select("select id,name,telephone,avatar_url,wechat_id from user where id = #{id}")
    User getUserInfoById(String id);


}
