package com.vaibhav.usersservice.controller;

import com.vaibhav.usersservice.dto.UserDto;
import com.vaibhav.usersservice.services.UserService;
import com.vaibhav.usersservice.uimodel.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private Environment environment;

    @Autowired
    private UserService userService;

    @GetMapping("/status/check")
    public String staus() {
        return "Woooo Running" + environment.getProperty("local.server.port");
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody  User user) {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDto userDto = modelMapper.map(user , UserDto.class);
        userService.createUser(userDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
    }

}
