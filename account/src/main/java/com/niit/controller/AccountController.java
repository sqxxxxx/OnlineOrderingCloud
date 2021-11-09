package com.niit.controller;

import com.niit.entity.Admin;
import com.niit.entity.User;
import com.niit.dao.AdminMapper;
import com.niit.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/account")
@Transactional
public class AccountController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    AdminMapper adminMapper;

    //用户登录
    @GetMapping("/userlogin/{username}/{password}")
    public User userLogin(@PathVariable("username") String username, @PathVariable("password") String password){
        return userMapper.userLogin(username,password);
    }

    //管理员登录
    @GetMapping("/adminlogin/{username}/{password}")
    public Admin adminLogin(@PathVariable("username") String username, @PathVariable("password") String password){
        return adminMapper.adminLogin(username,password);
    }

    //用户添加
    @PostMapping("/save")
    public void save(@RequestBody User user){
        user.setRegisterdate(new Date());
        userMapper.save(user);
    }
}
