package com.niit.controller;


import com.niit.entity.Admin;
import com.niit.entity.Msg;
import com.niit.entity.User;
import com.niit.feign.AccountFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/account")
public class LoginHandle {

    @Autowired
    private AccountFeign accountFeign;

//    @PostMapping("/login")
//    public String login(@RequestParam("username1") String username, @RequestParam("password1") String password, @RequestParam("type") String type, HttpSession session){
//        String result =null;
//        if (type==null){
//            result ="redirect:/login.html";
//        }else {
//            switch (type){
//                case "user":
//                    User user = accountFeign.userLogin(username,password);
//                    session.setAttribute("user",user);
//                    result ="redirect:/index.html";
//                    break;
//                case "admin":
//                    Admin admin = accountFeign.adminLogin(username,password);
//                    session.setAttribute("admin",admin);
//                    result="redirect:/main.html";
//                    break;
//            }
//        }
//        return result;
//    }

    @PostMapping("/login")
    public String login(@RequestParam("username1") String username, @RequestParam("password1") String password, @RequestParam("type") String type, HttpSession session, HttpServletResponse response){
        String result =null;
        if (type==null){
            result ="redirect:/login.html";
        }else {
            switch (type){
                case "user":
                    User user = accountFeign.userLogin(username,password);
                    session.setAttribute("user",user);
                    result ="redirect:/index.html";
                    break;
                case "admin":
                    Admin admin = accountFeign.adminLogin(username,password);
                    session.setAttribute("admin",admin);
                    result="redirect:/main.html";
                    break;
            }
        }
        return result;
    }

    @GetMapping("/allname")
    @ResponseBody
    public Msg redirect(HttpSession session){
        User user = (User) session.getAttribute("user");
        Admin admin = (Admin) session.getAttribute("admin");
        return Msg.success().add("user",user).add("admin",admin);
    }

    /*用户添加*/
    @PostMapping("/save")
    @ResponseBody
    public Msg usersave(User user){
        accountFeign.save(user);
        return Msg.success();
    }

    //*退出系统
    @GetMapping("/logout/{type}")
    public String logout(@PathVariable("type")String type,HttpSession session){
        switch (type){
            case "user":
                User user=(User)session.getAttribute("user");
//                System.out.println(user.getId()+" "+user.getUsername()+" "+user.getPassword()+" "+user.getNickname()+" "+user.getAddress());
                session.removeAttribute("user");
                break;
            case "admin":
                session.removeAttribute("admin");
                break;
        }
        return "redirect:/login.html";
    }



}
