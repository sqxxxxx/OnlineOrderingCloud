package com.niit.entity;

import lombok.Data;

/**
 * @auther snowy
 * @date 2020/1/19 - 21:59
 */
@Data// 注在类上，提供类的get、set、equals、hashCode、canEqual、toString方法
public class Menu {
    private long id;
    private String name;
    private double price;
    private String flavor;
    private Type type;

}
