package com.vaibhav.usersservice.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;


@Data
public class UserDto implements Serializable {


    @Serial
    private static final long serialVersionUID = 8333398620131679832L;

    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String encryptedPassword;
    private String userId;

}
