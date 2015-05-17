package com.Fairy.VocalsStudio.jdbc;

import com.Fairy.VocalsStudio.dao.UserDao;
import com.Fairy.VocalsStudio.logic.DBConnectionFactory;
import com.Fairy.VocalsStudio.models.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Wyvern on 12.05.2015.
 */
public class JdbsUserDao implements UserDao {
    @Override
    public User find(int id) {
        User user = null;
        try (Connection con = DBConnectionFactory.getDBConnection();) {

            ResultSet result = con.createStatement().executeQuery("SELECT * FROM users WHERE id_user = " + id + ";");

            if (result.next()) {
                int id_userBD = result.getInt("id_user");
                String loginBD = result.getString("login");
                String passwordBD = result.getString("password");
                String nameBD = result.getString("name");
                String surnameBD = result.getString("surname");
                String phone_numberBD = Integer.toString(result.getInt("phone_number"));
                String emailBD = result.getString("email");
                String sexBD = result.getString("sex");
                String roleBD = result.getString("role");

                user = new User(id_userBD, loginBD, passwordBD, nameBD, surnameBD, phone_numberBD, emailBD, sexBD, roleBD);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User update(User value) {
        return null;
    }

    @Override
    public User create(User value) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public User findByLogin(String loginParam) throws SQLException {

        User user = null;
        try (Connection con = DBConnectionFactory.getDBConnection()) {

            ResultSet result = con.createStatement().executeQuery("SELECT * FROM users WHERE login='" +
                    loginParam + "';");

            if (result.next()) {
                int id_userBD = result.getInt("id_user");
                String loginBD = result.getString("login");
                String passwordBD = result.getString("password");
                String nameBD = result.getString("name");
                String surnameBD = result.getString("surname");
                String phone_numberBD = Integer.toString(result.getInt("phone_number"));
                String emailBD = result.getString("email");
                String sexBD = result.getString("sex");
                String roleBD = result.getString("role");


                user = new User(id_userBD, loginBD, passwordBD, nameBD, surnameBD, phone_numberBD, emailBD, sexBD, roleBD);
                }
            }
        return user;
    }
}