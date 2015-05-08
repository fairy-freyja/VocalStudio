package com.Fairy.VocalsStudio.models;

/**
 * Created by Wyvern on 08.05.2015.
 */
public class UserBean {
    private String name;
    private String pass;
    private String email;

    public UserBean(String name, String pass, String email) {
        this.name = name;
        this.pass = pass;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }

    public String getEmail() {
        return email;
    }
}

