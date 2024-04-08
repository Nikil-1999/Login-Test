package com.assignment.logintest.services;

import java.util.Map;

import javax.management.InvalidAttributeValueException;

public interface loginTestService {

    public Boolean loginTest(String loginType, Map<String, String> paramBody) throws InvalidAttributeValueException;

}
