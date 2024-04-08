package com.assignment.logintest.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;

@RestController
public class SessionController {

    @Value("${okta.client.connection-timeout}")
    private String TEST_VALUE;

    @GetMapping("/setSessionAttribute")
    public String setSessionAttribute(HttpSession session) {
        session.setAttribute("testAttribute", TEST_VALUE);
        return "Session attribute set successfully";
    }

    @GetMapping("/getSessionAttribute")
    public String getSessionAttribute(HttpSession session) {
        String attributeValue = (String) session.getAttribute("testAttribute");
        return attributeValue != null ? attributeValue : "Session attribute not found";
    }
}