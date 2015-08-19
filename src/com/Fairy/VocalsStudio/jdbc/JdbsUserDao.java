package com.Fairy.VocalsStudio.jdbc;

import com.Fairy.VocalsStudio.dao.UserDao;
import com.Fairy.VocalsStudio.logic.DBConnectionFactory;
import com.Fairy.VocalsStudio.models.User;
import com.Fairy.VocalsStudio.models.UserBuilder;
import com.Fairy.VocalsStudio.services.UserHomeService;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wyvern on 12.05.2015.
 */
public class JdbsUserDao implements UserDao {
    private Logger log = Logger.getLogger(JdbsUserDao.class);
    private static String SELECT_BY_LR_STATUS = "SELECT * FROM users WHERE id_user IN (SELECT DISTINCT lr_id_user FROM lesson_request WHERE status = ?)";
    private static String UPDATE = "UPDATE users SET login = ?, password= ?, name= ?, surname = ?, phone_number = ?, email= ?, sex= ? WHERE id_user= ?";
    private static String CREATE = "INSERT INTO users set login = ?, password = ?, name = ?, surname = ?, phone_number = ?, email = ?, sex = ?";
    private static String SELECT_ALL = "SELECT * FROM users";

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
//    private static String UPDATE = "UPDATE users SET login = ?, password= ?, name= ?, surname = ?, phone_number = ?, email= ?, sex= ?, role= ? WHERE id_user= ?";
    public int update(User user) {
        int countUpdate = 0;
        try (Connection con = DBConnectionFactory.getDBConnection()) {
            try (PreparedStatement ps = con.prepareStatement(UPDATE)) {
                ps.setString(1, user.getLogin());
                ps.setString(2, user.getPassword());
                ps.setString(3, user.getName());
                ps.setString(4, user.getSurname());
                ps.setString(5, user.getPhoneNumber());
                ps.setString(6, user.getEmail());
                ps.setString(7, user.getSex());
                ps.setInt(8, user.getIdUser());

                countUpdate = ps.executeUpdate();
                if(countUpdate == 1) {
                    log.log(Level.INFO, "Update user " + user.getIdUser() + " finish successfully");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                log.log(Level.ERROR, "Trouble happened when try update user " +  user.getIdUser(), e);
            }
        } catch (SQLException e){
            e.printStackTrace();
            log.log(Level.ERROR, "Trouble with connection to DB", e);
        }
        return countUpdate;
    }

    @Override
    public int create(User value){
        int countUpdate = 0;
        try (Connection con = DBConnectionFactory.getDBConnection()) {
            try (PreparedStatement ps = con.prepareStatement(UPDATE)) {

                ps.setString(1, value.getLogin());
                ps.setString(2, value.getPassword());
                ps.setString(3, value.getName());
                ps.setString(4, value.getSurname());
                ps.setString(5, value.getPhoneNumber());
                ps.setString(6, value.getEmail());
                ps.setString(7, value.getSex());

                countUpdate = ps.executeUpdate(CREATE);

                log.log(Level.INFO, "Creation user was saccess fully");
            } catch (SQLException e){
                e.printStackTrace();
                log.log(Level.ERROR, "Trouble happened, when try create user", e);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            log.log(Level.ERROR, "Trouble with connection to DB, when try create user", e);
        }
        return countUpdate;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public User findByLogin(String login) throws SQLException {

        User user = null;
        try (Connection con = DBConnectionFactory.getDBConnection()) {

            ResultSet result = con.createStatement().executeQuery("SELECT * FROM users WHERE login='" +
                    login + "';");

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

    @Override
    public List<User> selectUsersByLRStatus(String status) throws SQLException {
        List<User> userList = null;
        try (Connection con = DBConnectionFactory.getDBConnection()) {
            try (PreparedStatement ps = con.prepareStatement(SELECT_BY_LR_STATUS)) {
                ps.setString(1, status);
                ResultSet result = ps.executeQuery();
                while (result.next()) {
                    if (userList == null) {
                        userList = new ArrayList<>();
                    }
                    int idUser = result.getInt("id_user");
                    String login = result.getString("login");
                    String password = result.getString("password");
                    String name = result.getString("name");
                    String surname = result.getString("surname");
                    String email = result.getString("email");
                    String sex = result.getString("sex");
                    String role = result.getString("role");
                    String phoneNumber = result.getString("phone_number");
                    userList.add(new UserBuilder().setIdUser(idUser).setLogin(login).setPassword(password).setName(name)
                            .setSurname(surname).setEmail(email).setPhoneNumber(phoneNumber).setSex(sex).setRole(role)
                            .build());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public List<User> findAll() {
        List<User> userList = null;
        try (Connection con = DBConnectionFactory.getDBConnection()) {
            try (PreparedStatement ps = con.prepareStatement(SELECT_ALL)) {
                ResultSet result = ps.executeQuery();
                while (result.next()) {
                    if (userList == null) {
                        userList = new ArrayList<>();
                    }
                    int idUser = result.getInt("id_user");
                    String login = result.getString("login");
                    String password = result.getString("password");
                    String name = result.getString("name");
                    String surname = result.getString("surname");
                    String email = result.getString("email");
                    String sex = result.getString("sex");
                    String role = result.getString("role");
                    String phoneNumber = result.getString("phone_number");
                    userList.add(new UserBuilder().setIdUser(idUser).setLogin(login).setPassword(password).setName(name)
                            .setSurname(surname).setEmail(email).setPhoneNumber(phoneNumber).setSex(sex).setRole(role)
                            .build());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }
}