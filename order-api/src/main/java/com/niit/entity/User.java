package com.niit.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @auther snowy
 * @date 2020/1/30 - 15:50
 */
@Data
public class User {
    private long id;
    private String username;
    private String password;
    private String nickname;
    private String gender;
    private String telephone;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss",timezone = "GMT+8")
    private Date registerdate;
    private String address;
    private int state;

}
