package com.shop.user.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class UserRegisterDTO {

    @NotEmpty
    private String name;

    @NotEmpty
    private String surname;

    @NotEmpty
    private Integer age;

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    private String password;
    private String matchingPassword;
}
