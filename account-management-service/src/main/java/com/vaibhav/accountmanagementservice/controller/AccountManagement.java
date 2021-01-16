package com.vaibhav.accountmanagementservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/account")
public class AccountManagement {



    @GetMapping("/status/check")
    public String getStatus() {
        return "Woooo Running Account";
    }
}
