package com.niit.dao;

import com.niit.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper{
    User userLogin(@Param("username")String username, @Param("password")String password);//用户登录
    void save(User user);//用户注册
}