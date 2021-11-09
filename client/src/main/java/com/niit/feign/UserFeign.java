package com.niit.feign;

import com.niit.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Component
@FeignClient(value = "user")
public interface UserFeign {
    //查询所有用户信息
    @GetMapping("/user/findAll/{index}/{limit}")
    List <User> findAll(@PathVariable("index") Integer index, @PathVariable("limit") Integer limit);

    @GetMapping("/user/findInfo/{id}")
    User findInfo(@PathVariable("id")long id);

    //    M 管理员欲修改信息查找
    @GetMapping("/user/adminFindInfo/{uid}")
    User adminFindInfo(@PathVariable("uid")long uid);

    //查询信息数目
    @GetMapping("/user/count")
    Integer count();

    //用户添加
    @PostMapping("/user/save")
    void save(@RequestBody User user);

    //修改
    @PutMapping("/user/modify")
    void modify(@RequestBody User user);

    // 用户删除
    @PutMapping("/user/deleteById/{id}")
    void deleteById(@PathVariable("id") long id);

    @GetMapping("/user/queryUsername")
    int queryUsername(@RequestParam("username")String username);
}
