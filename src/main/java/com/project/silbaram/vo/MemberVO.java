package com.project.silbaram.vo;

import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {
    private int mid;
    private String userId;
    private String password;
    private String nickName;
    private String name;
    private LocalDate birthDate;
    private String gender;
    private String phoneNumber;
    private String email;
    private String zipcode;
    private String address;
    private boolean socialLogin;
    private boolean isAdmin;
    private LocalDate regDate;
}