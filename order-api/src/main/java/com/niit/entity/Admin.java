package com.niit.entity;

import lombok.Data;

/**
 * @auther snowy
 * @date 2020/2/2 - 23:18
 */
@Data
public class Admin {
    private long id;
    private String username;
    private String password;
    private int state;

}
