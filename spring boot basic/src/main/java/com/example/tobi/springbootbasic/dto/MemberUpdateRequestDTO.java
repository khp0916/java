package com.example.tobi.springbootbasic.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class MemberDeleteDTO {
    private String userid;
    private String password;
}
