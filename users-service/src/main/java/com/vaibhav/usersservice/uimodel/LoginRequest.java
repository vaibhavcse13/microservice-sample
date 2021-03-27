package com.vaibhav.usersservice.uimodel;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LoginRequest {

    @NotNull(message = "Email should not be blank")
    private String email;
    @NotNull(message = "Password Should not be blank")
    private String password;

}
