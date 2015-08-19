package com.Fairy.VocalsStudio.dao;

import com.Fairy.VocalsStudio.models.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Wyvern on 12.05.2015.
 */
public interface UserDao extends InterfaceDao<User> {
    User findByLogin(String login) throws SQLException;
    List<User> selectUsersByLRStatus(String status) throws SQLException;

    List<User> findAll();
}
