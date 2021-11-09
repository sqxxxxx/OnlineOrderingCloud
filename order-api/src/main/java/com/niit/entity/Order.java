package com.niit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @auther snowy
 * @date 2020/2/5 - 22:10
 */
@Data
public class Order {
    private long id;
    private User user;
    private OrderInfo orderinfo;
    private Menu menu;
    private int count;//数量
    private double subtotal;//小计
    private String menuname;//菜单名聚合


//    private Admin admin;
//    private Date date;
//    private int state;//string改成int
}
