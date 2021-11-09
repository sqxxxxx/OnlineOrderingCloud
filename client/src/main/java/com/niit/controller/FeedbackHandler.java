package com.niit.controller;

import com.niit.entity.*;
import com.niit.feign.FeedbackFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/feedback")
public class FeedbackHandler {

    @Autowired
    private FeedbackFeign feedbackFeign;


    //提交反馈
    @PostMapping("/save")
    @ResponseBody
    public Msg save(Feedback feedback, HttpSession session){
        User user = (User) session.getAttribute("user");
        feedback.setUser(user);
        feedbackFeign.save(feedback);
        return Msg.success();
    }

    //提交菜品意见
    @PostMapping("/commentSave")
    @ResponseBody
    public Msg commentSave(Comments comments, HttpSession session){
        User user=(User)session.getAttribute("user");
        comments.setUser(user);
        System.out.println(comments);
        feedbackFeign.commentSave(comments);
        return Msg.success();
    }

    //提交订单评价
    @PostMapping("/orderAccsss")
    @ResponseBody
    public Msg orderAccsss(){

        return Msg.success();
    }
    @GetMapping("/showFeedback")
    @ResponseBody
    public AllVO showFeedback(@RequestParam("page")int page,@RequestParam("limit")int limit){
        return new AllVO(0,"",feedbackFeign.feedbackCount(),feedbackFeign.showFeedback((page-1)*limit, limit));
    }

    @GetMapping("/showComments")
    @ResponseBody
    public AllVO showComments(@RequestParam("page")int page,@RequestParam("limit")int limit){
        return new AllVO(0,"",feedbackFeign.commentsCount(),feedbackFeign.showComments((page-1)*limit, limit));
    }
}
