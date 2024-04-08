package com.assignment.logintest.security;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableOAuth2Sso
@Order(2) // Set a different unique order value for the OAuth2 SSO configuration
public class OktaOAuth2Configuration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // OAuth2 SSO configuration
        http.antMatcher("/**")
                .authorizeRequests(requests -> requests
                        .antMatchers("/", "/login**").permitAll()
                        .anyRequest().authenticated()).logout(logout -> logout.logoutSuccessUrl("/login").permitAll()).oauth2Login(login -> login.defaultSuccessUrl("/secure")).csrf(csrf -> csrf.disable());
    }
}