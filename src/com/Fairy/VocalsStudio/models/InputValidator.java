package com.Fairy.VocalsStudio.models;

/**
 * Created by Wyvern on 08.05.2015.
 */
public class InputValidator {
    private static String LOGIN_PATTERN = "[A-z][\\w]{3,19}";
    private static String PASSWORD_PATTERN = "[\\d]{4,15}";
    private static String EMAIL_PATTERN = "^\\w+[\\w-\\.]*\\@\\w+((-\\w+)|(\\w*))\\.[a-z]{2,3}$";

    public static boolean validateLogin(String login){
        return login.matches(LOGIN_PATTERN);
    }

    public static boolean validatePassword(String password){
        return password.matches(PASSWORD_PATTERN);
    }

    public static boolean validateEmail(String email){
        return email.matches(EMAIL_PATTERN);
    }
}
