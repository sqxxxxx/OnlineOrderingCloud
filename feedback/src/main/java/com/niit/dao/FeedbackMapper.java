package com.niit.dao;

import com.niit.entity.Feedback;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackMapper {
    void save(Feedback feedback);//提交反馈

    //反馈展示
    List<Feedback> showFeedback(int page,int limit);

    //反馈条数
    int feedbackCount();
}
