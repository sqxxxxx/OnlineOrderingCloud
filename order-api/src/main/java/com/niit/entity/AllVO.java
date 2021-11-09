package com.niit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllVO {
    private Integer code;
    private String msg;
    private Integer count;
    private List data;


}
