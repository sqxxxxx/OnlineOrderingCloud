package com.niit.controller;

import com.niit.entity.Comments;
import com.niit.entity.Feedback;
import com.niit.dao.CommentsMapper;
import com.niit.dao.FeedbackMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedback")
@Transactional
public class FeedbackController {
    @Autowired
    FeedbackMapper feedbackMapper;

    @Autowired
    CommentsMapper commentsMapper;
    //提交反馈
    @PostMapping("/save")
    public void save(@RequestBody Feedback feedback){
        feedbackMapper.save(feedback);
    }

    //提交菜品意见
    @PostMapping("/commentSave")
    public void commentSave(@RequestBody Comments comments){
        commentsMapper.commentSave(comments);
    }

    //反馈条数
    @GetMapping("/feedbackCount")
    public int feedbackCount(){
        return feedbackMapper.feedbackCount();
    }

    //显示反馈
    @GetMapping("/showFeedback/{page}/{limit}")
    public List<Feedback> showFeedback(@PathVariable("page")int page,@PathVariable("limit")int limit){
        return feedbackMapper.showFeedback(page,limit);
    }

    //评价展示
    @GetMapping("/showComments/{page}/{limit}")
    public List<Comments> showComments(@PathVariable("page")int page,@PathVariable("limit")int limit){
        return commentsMapper.showComments(page, limit);
    }
    //评价条数
    @GetMapping("/commentsCount")
    public int commentsCount(){
        return commentsMapper.commentsCount();
    }

}
