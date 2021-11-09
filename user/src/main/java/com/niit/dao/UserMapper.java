package com.niit.dao;

import com.niit.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserMapper {
    List<User> findAll(Integer index, Integer limit);//查询所有用户信息
    User findInfo(long id);
    //    M 管理员欲修改信息查找
    User adminFindInfo(long uid);
    Integer count();    //查询信息数目
    void save(User user);//用户添加
    void modify(User user);//用户修改
    void deleteById(long id); // 用户删除
    int queryUsername(String username);//查询是否重复
}
