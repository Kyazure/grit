package com.hdjd.grit.mapper;

import com.hdjd.grit.model.dto.ExtendComments;
import com.hdjd.grit.model.pojo.Comments;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author yeqi
 */
@Mapper
public interface CommentsMapper {

    /**
     * 插入用户的评论信息
     *
     * @param  comments
     * @return 是否插入成功
     */
    @Insert("insert into comments (id,user_id,content,delivery,server) values(#{id},#{userId},#{content},#{delivery},#{server})")
    int insert(Comments comments);


    /**
     * 查询用户的评论信息
     * @return 所有的评论信息
     */
//    @Select("select id,user_id,content,delivery,server,create_time,update_time from comments")
    @Select("SELECT comments.id AS 'id',name,avatar_url,user_id,content,delivery,server,comments.create_time,comments.update_time \n" +
            "FROM comments,user\n" +
            "WHERE comments.user_id = user.`id` ORDER BY comments.create_time DESC")
    List<ExtendComments> getAllComments();

    /**
     * 删除用户的评论信息
     * @return 根据id
     */
    @Delete("delete from comments where id =#{id} ")
    int deleteById(String id);

}
