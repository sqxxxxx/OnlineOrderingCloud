package com.niit.entity;

import lombok.Data;

/**
 * @author 君已陌路
 * @date 2021/10/8 22:53
 */
@Data
//等价于上面的@Setter、@Getter、@RequiredArgsConstructor、@ToString、@EqualsAndHashCode
public class Comments {
    private long id;
    private User user;
    private Menu menu;
    private int star;
    private String comment;
    private int state;
}
