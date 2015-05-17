package com.Fairy.VocalsStudio.dao;

import com.Fairy.VocalsStudio.models.User;

import java.sql.SQLException;

/**
 * Created by Wyvern on 12.05.2015.
 */
public interface UserDao extends InterfaceDao<User> {
    public User findByLogin(String login) throws SQLException;
}
