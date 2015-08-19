package com.Fairy.VocalsStudio.services;

import com.Fairy.VocalsStudio.dao.DaoFactory;
import com.Fairy.VocalsStudio.dao.UserDao;
import com.Fairy.VocalsStudio.models.User;

import java.sql.SQLException;

/**
 * Created by Wyvern on 19.05.2015.
 */
public class LoginService  {
    private UserDao ud = DaoFactory.getInstance().createUserDao();

    public boolean checkLogin(String login){
        User user = null;
        try {
            user = ud.findByLogin(login);
        } catch (SQLException e) {
            return false;
        }
        return user != null;
    }


    public boolean checkLoginPass(String login, String password){
        if(!(InputValidator.validateLogin(login) && InputValidator.validatePassword(password))){
            return false;
        }

        User user = null;
        try {
            user = ud.findByLogin(login);
        } catch (SQLException e) {
            return false;
        }
        if (user != null) {
            System.out.println("req.getParameter(login) = " + login);
            if (user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public User findUserByLogin(String login){
        User user = null;
        try {
            user = ud.findByLogin(login);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

}
