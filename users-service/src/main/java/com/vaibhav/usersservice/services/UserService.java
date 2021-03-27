package com.vaibhav.usersservice.services;

import com.vaibhav.usersservice.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    UserDto createUser(UserDto user);

    String getUserId(String email);
}
