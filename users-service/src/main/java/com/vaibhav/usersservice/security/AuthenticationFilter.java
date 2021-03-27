package com.vaibhav.usersservice.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaibhav.usersservice.services.UserService;
import com.vaibhav.usersservice.uimodel.LoginRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;



public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {


    private final UserService userService;
    private AuthenticationManager authenticationManager;

    public AuthenticationFilter(UserService userService , AuthenticationManager authenticationManager) {
        this.userService = userService;
        super.setAuthenticationManager(authenticationManager);
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        LoginRequest cred =null;
        try{
          cred   = new ObjectMapper().readValue(request.getInputStream(), LoginRequest.class);
        }catch (IOException ex) {
            throw new RuntimeException("Unable to read the request ");
        }

        return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(cred.getEmail() , cred.getPassword() , new ArrayList<>()));

    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        String username  =  ((User)authResult.getPrincipal()).getUsername();
        String userId   = userService.getUserId(username);
    }
}
