package com.assignment.logintest.services;

import java.util.Map;
import javax.management.InvalidAttributeValueException;

public class loginTestServiceImpl implements loginTestService {

    static final String loginTypeStringError = "Invalid loginType value. Valid options: usernamePassword, okta";

    @Override
    public Boolean loginTest(String loginType, Map<String, String> paramBody) throws InvalidAttributeValueException {
        if (loginType == null || loginType.isEmpty() || loginType.isBlank()) 
            throw new InvalidAttributeValueException(loginTypeStringError);
        if (loginType.toLowerCase().equals("usernamePassword")) {
            return userPassCheck(paramBody);
        } else if (loginType.toLowerCase().equals("okta")) {
            return oktaVerifyCheck(paramBody);
        }
        throw new InvalidAttributeValueException(loginTypeStringError);
    }

    private Boolean userPassCheck(Map<String, String> paramBody) {
        return false;
    }

    private Boolean oktaVerifyCheck(Map<String, String> paramBody) {
        return false;
    }

}
