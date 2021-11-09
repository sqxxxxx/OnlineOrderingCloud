package com.niit.entity;

import lombok.Data;

@Data
public class Feedback {
    private long id;
    private User user;
    private String title;
    private String email;
    private String ufeedback;
    private int state;
}
