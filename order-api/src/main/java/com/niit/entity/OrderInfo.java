package com.niit.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.niit.utils.LongJsonDeserializer;
import com.niit.utils.LongJsonSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class OrderInfo {
    private long id;
    private User user;
    @JsonDeserialize(using = LongJsonDeserializer.class)
    @JsonSerialize(using = LongJsonSerializer.class)
    private long orderid;
    private int total;
    private double money;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss",timezone = "GMT+8")
    private Date date;
    private int star;
    private String comments;
    private int state;//string改成int
    private int delstate;

}
