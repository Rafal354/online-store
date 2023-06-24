package com.shop.user.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class UserLoginDTO {

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    private String password;
}
