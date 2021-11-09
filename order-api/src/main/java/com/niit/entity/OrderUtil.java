package com.niit.entity;

import lombok.Data;

/**
 * @author 君已陌路
 * @date 2021/10/3 19:23
 */
@Data
public class OrderUtil {
    private long id;
    private String name;
    private int total;
    private double money;
}
