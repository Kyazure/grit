package com.hdjd.grit.mapper;

import com.hdjd.grit.model.pojo.User;
import com.hdjd.grit.model.pojo.UserAndAddress;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName:UserAndAddressProvider
 * @author: yeqi
 * @create: 2020/3/6 9:12
 * @description
 */

public class UserAndAddressProvider {

    /*
     * 创建一个更新的SQL语句
     *
     * @param userAndAddress
     * @return
     */
    public String updateUserAndAddressByIdSql(UserAndAddress userAndAddress){
        return new SQL() {{
            UPDATE("user_address");
            if (StringUtils.isNoneBlank(userAndAddress.getAddress())) {
                SET("address=#{address}");
            }
            if (StringUtils.isNoneBlank(userAndAddress.getContactName())) {
                SET("contact_name=#{contactName}");
            }
            if (StringUtils.isNoneBlank(userAndAddress.getContactPhone())) {
                SET("contact_phone=#{contactPhone}");
            }
            if (StringUtils.isNoneBlank(userAndAddress.getBuildingNature())) {
                SET("building_nature=#{buildingNature}");
            }
            if (StringUtils.isNoneBlank(userAndAddress.getPropertyNature())) {
                SET("property_nature=#{propertyNature}");
            }
            if (StringUtils.isNoneBlank(userAndAddress.getLongitude())) {
                SET("longitude=#{longitude}");
            }
            if (StringUtils.isNoneBlank(userAndAddress.getLatitude())) {
                SET("latitude=#{latitude}");
            }
            WHERE("id=#{id}");
        }}.toString();
    }

}
