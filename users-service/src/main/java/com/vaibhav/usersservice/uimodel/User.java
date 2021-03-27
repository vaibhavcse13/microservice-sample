package com.vaibhav.usersservice.uimodel;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class User {

    @NotNull(message = "Firstname should not be null")
    @Size(min = 2 , message ="Last name must not be less then two character")
    private String firstName;
    private String lastName;
    @NotNull(message = "Password field should not be null")
    @Size(min = 8 , max = 16 , message = "Password should be more than 8 character and less then 16 character")
    private String password;
    @NotNull(message = "Email should not be null")
    @Email
    private String email;
}
