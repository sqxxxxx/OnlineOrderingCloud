package com.niit.controller;


import com.niit.entity.AllVO;
import com.niit.entity.Msg;
import com.niit.entity.User;
import com.niit.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserHandler {


    @Autowired
    UserFeign userFeign;

    /*查询所有所有用户*/
    @GetMapping("/findAll")
    @ResponseBody
    public AllVO findAll(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit){
        Integer index = (page-1)*limit;
        return new AllVO(0,"",userFeign.count(),userFeign.findAll(index, limit));
    }
    /*用户查询单个用户信息*/
    @GetMapping("/findInfo")
    @ResponseBody
    public Msg findInfo(HttpSession session){
        User user=(User)session.getAttribute("user");

//        User user1=userFeign.findInfo(user.getId());
//        model.addAttribute("user1",user1);
//        return "redirect:/modify_info.html";
//        return new UserIO(0,"",1,userFeign.findInfo(user.getId()));
            return  Msg.success().add("userInfo",userFeign.findInfo(user.getId()));
    }

//    M 管理员欲修改信息查找
    @GetMapping("/adminFindInfo/{uid}")
    @ResponseBody
    public Msg adminFindInfo(@PathVariable("uid")long uid){
        return Msg.success().add("userInfo",userFeign.adminFindInfo(uid));
    }

    /*用户添加*/
    @PostMapping("/save")
//    @ResponseBody
    public String usersave(User user){
        userFeign.save(user);
        return "redirect:/user_manage.html";
//        return Msg.success();
    }

    /* 用户修改*/
    @PutMapping("/modifyUser")
    @ResponseBody
    public Msg userModify(HttpSession session,User user){
        User user1=(User)session.getAttribute("user");
        user.setId(user1.getId());
        System.out.println(user.toString());
        userFeign.modify(user);
        return Msg.success();
    }

    /* 管理员修改*/
    @PutMapping("/modify")
    @ResponseBody
    public Msg adminModify(User user){
        System.out.println(user.toString());
        userFeign.modify(user);
        return Msg.success();
    }
    //用户删除,不支持put，下面那种才执行不知道为啥
//    @PutMapping("/deleteById/{id}")
//    public String deleteById(@PathVariable("id") long id){
//        userFeign.deleteById(id);
//        return "redirect:/user_manage.html";
//    }
//用户删除
@PutMapping("/deleteById/{id}")
@ResponseBody
public Msg deleteById(@PathVariable("id") long id){
    userFeign.deleteById(id);
    return Msg.success();
}

    //用户名是否重复查询
    @GetMapping("/queryUsername")
    @ResponseBody
    public Msg queryUsername(@RequestParam("username")String username){
        System.out.println(username);
        int u=userFeign.queryUsername(username);
        System.out.println("出结果："+u);
        return u>0?Msg.fail():Msg.success();
    }
}
