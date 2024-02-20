package com.password.generator;

import org.apache.commons.lang3.RandomStringUtils;

public class NumericPasswordGenerator implements PasswordGenerator{
    @Override
    public String generatedPassword() {
        return RandomStringUtils.randomNumeric(6);
    }
}
