package com.niit.dao;

import com.niit.entity.Comments;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 君已陌路
 * @date 2021/10/14 23:31
 */
@Repository
public interface CommentsMapper {

    void commentSave(Comments comments);

    //评论条数
    int commentsCount();
    //    菜品点评查看
    List<Comments> showComments(int page,int limit);
}
