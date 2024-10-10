package com.example.tobi.springbootbasicboardpractice.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class member {
    private String userId;
    private String password;
    private String userName;
}
