package com.vaibhav.accountmanagementservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AccountManagementServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountManagementServiceApplication.class, args);
    }

}
