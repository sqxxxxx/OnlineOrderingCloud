package com.niit.controller;


import com.niit.entity.User;
import com.niit.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
@Transactional
public class UserController {

    @Autowired
    UserMapper userMapper;

    //查询所有用户信息
    @GetMapping("/findAll/{index}/{limit}")
    public List< User > findAll(@PathVariable("index") Integer index, @PathVariable("limit") Integer limit){
        return userMapper.findAll(index,limit);
    }
    @GetMapping("/findInfo/{id}")
    public User findInfo(@PathVariable("id")long id){
        return  userMapper.findInfo(id)  ;
    }

    //    M 管理员欲修改信息查找
    @GetMapping("/adminFindInfo/{uid}")
    public User adminFindInfo(@PathVariable("uid")long uid){
        return  userMapper.adminFindInfo(uid)  ;
    }

    //查询信息数目
    @GetMapping("/count")
    public Integer count(){
        return userMapper.count();
    }

    //用户添加
    @PostMapping("/save")
    public void save(@RequestBody User user){
        user.setRegisterdate(new Date());
        userMapper.save(user);
    }

    //信息修改
    @PutMapping("/modify")
    public void modify(@RequestBody User user){
        userMapper.modify(user);
    }
    // 用户删除
    @PutMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id")long id){
        userMapper.deleteById(id);
    }

    @GetMapping("/queryUsername")
    public int queryUsername(@RequestParam("username")String username){
        return userMapper.queryUsername(username);
    }
}
