package com.hdjd.grit.mapper;

import com.hdjd.grit.model.pojo.UserAndAddress;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author yeqi
 */
@Mapper
public interface UserAndAddressMapper {


    /**
     * 插入用户及地址信息
     *
     * @param userAndAddress
     * @return 是否插入成功
     */
    @Insert("insert into user_address(id,user_id,address,contact_name,contact_phone,building_nature,property_nature,longitude,latitude) values(#{id},#{userId},#{address},#{contactName},#{contactPhone},#{buildingNature},#{propertyNature},#{longitude},#{latitude})")
    int insert(UserAndAddress userAndAddress);


    /**
     * 删除信息 通过id
     * @param id
     * @return 是否删除成功
     */
    @Delete("delete from user_address where id = #{id}")
    int deleteById(String id);

    /**
     * 通过id更新用户及地址信息
     * @param userAndAddress
     * @return 是否更新成功
     */
    @UpdateProvider(type = UserAndAddressProvider.class,method = "updateUserAndAddressByIdSql")
    int updateById(UserAndAddress userAndAddress);

    /*
     * 通过用户id查询用户的所有地址信息
     * @param userId
     * @return 是否更新成功
     */
    @Select("select id,user_id,address,contact_name,contact_phone,building_nature,property_nature,longitude,latitude from user_address where user_id = #{userId}")
    List<UserAndAddress> getUserAddress(String userId);

}
