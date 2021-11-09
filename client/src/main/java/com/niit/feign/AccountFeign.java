package com.niit.feign;


import com.niit.entity.Admin;
import com.niit.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(value = "account")
public interface AccountFeign {
    //用户登录
    @GetMapping("/account/userlogin/{username}/{password}")
    User userLogin(@PathVariable("username") String username, @PathVariable("password") String password);

    //管理员登录
    @GetMapping("/account/adminlogin/{username}/{password}")
    Admin adminLogin(@PathVariable("username") String username, @PathVariable("password") String password);

    //用户注册
    @PostMapping("/account/save")
    void save(@RequestBody User user);

}
