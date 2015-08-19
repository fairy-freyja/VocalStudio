package com.Fairy.VocalsStudio.models;

/**
 * Created by Fairy on 6/8/2015.
 */
public class UserBuilder {
    private User user;

    public UserBuilder(){
        user = new User();
    }

    public User build(){
        return user;
    }

    public void refresh(){
        user = new User();
    }

    public UserBuilder setEmail(String email){
        user.setEmail(email);
        return this;
    }

    public UserBuilder setName(String name){
        user.setName(name);
        return this;
    }

    public UserBuilder setSurname(String surname){
        user.setSurname(surname);
        return this;
    }

    public UserBuilder setLogin(String login){
        user.setLogin(login);
        return this;
    }

    public UserBuilder setPassword(String password){
        user.setPassword(password);
        return this;
    }

    public UserBuilder setPhoneNumber(String phoneNumber){
        user.setPhoneNumber(phoneNumber);
        return this;
    }

    public UserBuilder setSex(String sex){
        user.setSex(sex);
        return this;
    }

    public UserBuilder setIdUser(int idUser){
        user.setIdUser(idUser);
        return this;
    }

    public UserBuilder setRole(String role){
        user.setRole(role);
        return this;
    }
}
