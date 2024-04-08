package com.assignment.logintest.controllers;

import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/loginTest")
public class LoginTestController {

    @Autowired
    private Environment environment;

    @GetMapping("u2pcheck")
    private Boolean login(@RequestParam(name = "username", required = true) String username, @RequestParam(name = "password", required = true) String password) {
        System.out.println("******************************TEST*******************************");

        if (username.equals(environment.getProperty("login.username")) && password.equals(environment.getProperty("login.password")))
            return true;

        return false;
    }

    public void session() throws InterruptedException {
        // Simulating some asynchronous operation
        System.out.println("********SESSION TEST*********");
        Thread.sleep(1000);
    }
}
