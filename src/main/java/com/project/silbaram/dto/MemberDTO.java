package com.project.silbaram.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDTO {
    private int mid;
    @NotEmpty
    private String userId;
    @NotEmpty
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
}