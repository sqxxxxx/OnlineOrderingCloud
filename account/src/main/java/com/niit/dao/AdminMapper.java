package com.niit.dao;

import com.niit.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {
    Admin adminLogin(@Param("username")String username, @Param("password")String password); //管理员登录
}
