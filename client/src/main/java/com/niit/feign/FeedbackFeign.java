package com.niit.feign;

import com.niit.entity.Comments;
import com.niit.entity.Feedback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
@FeignClient(value = "feedback")
public interface FeedbackFeign {
    //添加菜品
    @PostMapping("/feedback/save")
    void save(@RequestBody Feedback feedback);

    //提交菜品意见
    @PostMapping("/feedback/commentSave")
    void commentSave(@RequestBody Comments comments);


//    反馈查看
    @GetMapping("/feedback/showFeedback/{page}/{limit}")
    List<Feedback> showFeedback(@PathVariable("page")int page,@PathVariable("limit")int limit);

    //反馈条数
    @GetMapping("/feedback/feedbackCount")
    int feedbackCount();

    //    反馈查看
    @GetMapping("/feedback/showComments/{page}/{limit}")
    List<Comments> showComments(@PathVariable("page")int page,@PathVariable("limit")int limit);

    //评价条数
    @GetMapping("/feedback/commentsCount")
    int commentsCount();
}
