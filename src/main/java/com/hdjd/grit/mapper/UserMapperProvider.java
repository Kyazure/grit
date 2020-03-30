package com.hdjd.grit.mapper;

import com.hdjd.grit.model.pojo.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName:UserMapperProvider
 * @author: yeqi
 * @create: 2020/3/5 12:01
 * @description
 */

public class UserMapperProvider {


    /*
     * 创建一个更新的SQL语句
     *
     * @param user
     * @return
     */
    public String updateUserByIdSql(User user){
        return new SQL() {{
            UPDATE("user");
            if (StringUtils.isNoneBlank(user.getName())) {
                SET("name=#{name}");
            }
            if (StringUtils.isNoneBlank(user.getAvatarUrl())) {
                SET("avatar_url=#{avatarUrl}");
            }
            if (user.getTelephone() != null) {
                SET("telephone=#{telephone}");
            }
            WHERE("id=#{id}");
        }}.toString();
    }

}
