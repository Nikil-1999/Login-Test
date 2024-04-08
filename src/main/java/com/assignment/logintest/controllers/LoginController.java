package com.assignment.logintest.controllers;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@EnableOAuth2Sso
public class LoginController {

    @GetMapping("/user")
    public String getUser(Authentication authentication) {
        OAuth2User user = (OAuth2User) authentication.getPrincipal();
        return "Authenticated User: " + user.getName();
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/login-success")
    public String redirectToIndex() {
        return "redirect:/index";
    }

    @GetMapping("/secure")
    public String secure(@AuthenticationPrincipal OAuth2User principal, Model model) {
        model.addAttribute("principal", principal);
        return "secure";
    }

    @GetMapping("/home")
    public String home() {
        return "Welcome to the home page!";
    }

    @RequestMapping("/authorization-code/callback")
    public RedirectView handleCallback() {
        return new RedirectView("/index");
    }
}
