package com.assignment.logintest.services;

import org.springframework.beans.factory.annotation.Value;

public class AuthenticationService {

    @Value("${login.username}")
	private String usernameProp;

	@Value("${login.password}")
	private String passwordProp;

    public boolean validateCredentials(String username, String password) {
        // Perform validation logic
        if (username.equals(usernameProp) && password.equals(passwordProp)) {
            return true; // Credentials are valid
        } else {
            return false; // Credentials are not valid
        }
    }
}
