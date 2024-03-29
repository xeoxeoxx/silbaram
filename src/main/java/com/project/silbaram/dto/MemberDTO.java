package com.project.silbaram.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDTO {
    private int mid;
    @NotBlank(message = "아이디를 입력해주세요.")
    @Pattern(regexp = "^[a-z0-9_-]{5,15}$", message = "아이디는 5~15자의 영문소문자, 숫자, '_', '-' 만 가능합니다")
    private String userId;
    @NotEmpty(message = "비밀번호를 입력해주세요.")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#$%^&*])[A-Za-z\\d!@#$%^&*]{8,20}$", message = "비밀번호는 영문자, 숫자, 특수문자(!@#$%^&*)를 모두 포함하고 8자 이상 20자 이하여야 합니다.")
    private String password;

    @NotEmpty
    private String nickName;
    @NotEmpty
    private String name;
    @Past
    @NotNull
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate birthDate;
    @NotEmpty
    private String gender;
    @NotEmpty
    private String phoneNumber;
    @NotEmpty
    private String email;
    private String zipcode;
    private String address;
    private boolean socialLogin;
    @NotNull
    private boolean isAdmin;

    private String uuid;
}