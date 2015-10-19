package com.zhuke.test;

import com.zhuke.annotation.UseCase;

import java.util.List;

/**
 * Created by ZHUKE on 2015/10/19.
 */
public class PasswordUtils {
    @UseCase(id = 47, description = "passwords must contain at lease one number!")
    public boolean validatePassword(String password) {
        return password.matches("\\w*\\d\\w*");
    }

    @UseCase(id = 48)
    public String encryptPassword(String password) {
        return new StringBuilder(password).reverse().toString();
    }

    public boolean checkForNewPassword(List<String> prevPasswords, String password) {
        return !prevPasswords.contains(password);
    }
}
